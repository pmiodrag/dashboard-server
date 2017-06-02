package com.twinsoft.service.storage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.twinsoft.AwsResourceConfig;
import com.twinsoft.domain.PersonImage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileAmazonService {
	
//	private AwsResourceConfig config;
	private AmazonS3 s3Client;

	private static final String S3_BUCKET_NAME = "twinsoft-dashboard/patients"
			+ "";


	/**
	 * Save image to S3 and return PersonImage containing key and public URL
	 * 
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	public PersonImage saveFileToS3(MultipartFile multipartFile) throws FileAmazonException {
		
		try{
			s3Client = AwsResourceConfig.getAmazonS3Client();
			File fileToUpload = convertFromMultiPart(multipartFile);
			String key = fileToUpload.getName();
			//String key = Instant.now().getEpochSecond() + "_" + fileToUpload.getName();
			/* save file */
			s3Client.putObject(new PutObjectRequest(S3_BUCKET_NAME, key, fileToUpload));

			/* get signed URL (valid for one year) */
			GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(S3_BUCKET_NAME, key);
			generatePresignedUrlRequest.setMethod(HttpMethod.GET);
			//generatePresignedUrlRequest.setExpiration(LocalDate.now().plusYears(1).toEpochDay());

			URL signedUrl = s3Client.generatePresignedUrl(generatePresignedUrlRequest); 

			return new PersonImage(key, signedUrl.toString());
		} catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        
		} catch (IOException ex) {		
			throw new FileAmazonException("An error occurred saving file to S3", ex);
		}
		return null;
	}
	
	public S3Object getFileFromS3(String key) {
		 
	        try {
	        	s3Client = AwsResourceConfig.getAmazonS3Client();
	            System.out.println("Downloading an object");
	            S3Object s3object = s3Client.getObject(new GetObjectRequest(
	            		S3_BUCKET_NAME, key));
	            System.out.println("Content-Type: "  + 
	            		s3object.getObjectMetadata().getContentType());
//	            displayTextInputStream(s3object.getObjectContent());	            
	            return s3object;
	        } catch (AmazonServiceException ase) {
	            System.out.println("Caught an AmazonServiceException, which" +
	            		" means your request made it " +
	                    "to Amazon S3, but was rejected with an error response" +
	                    " for some reason.");
	            System.out.println("Error Message:    " + ase.getMessage());
	            System.out.println("HTTP Status Code: " + ase.getStatusCode());
	            System.out.println("AWS Error Code:   " + ase.getErrorCode());
	            System.out.println("Error Type:       " + ase.getErrorType());
	            System.out.println("Request ID:       " + ase.getRequestId());
	        } catch (AmazonClientException ace) {
	            System.out.println("Caught an AmazonClientException, which means"+
	            		" the client encountered " +
	                    "an internal error while trying to " +
	                    "communicate with S3, " +
	                    "such as not being able to access the network.");
	            System.out.println("Error Message: " + ace.getMessage());
	        }
			return null;
	}

	private static void displayTextInputStream(InputStream input)  throws IOException {
    	// Read one text line at a time and display.
        BufferedReader reader = new BufferedReader(new 
        		InputStreamReader(input));
        while (true) {
            String line = reader.readLine();
            if (line == null) break;

            System.out.println("    " + line);
        }
        System.out.println();
    }
	/**
	 * Delete image from S3 using specified key
	 * 
	 * @param customerImage
	 */
	public void deleteImageFromS3(PersonImage customerImage){
		s3Client.deleteObject(new DeleteObjectRequest(S3_BUCKET_NAME, customerImage.getKey()));	
	}

	/**
	 * Convert MultiPartFile to ordinary File
	 * 
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	private File convertFromMultiPart(MultipartFile multipartFile) throws IOException {

		File file = new File(multipartFile.getOriginalFilename());
		file.createNewFile(); 
		FileOutputStream fos = new FileOutputStream(file); 
		fos.write(multipartFile.getBytes());
		fos.close(); 

		return file;
	}
}