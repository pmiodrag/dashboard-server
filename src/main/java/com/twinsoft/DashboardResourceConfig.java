//package com.twinsoft;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.aws.context.support.io.ResourceLoaderBeanPostProcessor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//
//import com.amazonaws.services.s3.AmazonS3Client;
//
//@Configuration
////@ImportResource("classpath:/aws-config.xml")
///*@EnableRdsInstance(databaseName = "${database-name:}", 
//                   dbInstanceIdentifier = "${db-instance-identifier:}", 
//				   password = "${rdsPassword:}")*/
//public class DashboardResourceConfig {
//	
//	@Value("${accessKey}")
//	private String accessKey;
//	
//	@Value("${secretKey}")
//	private String secretKey;
//	
//	@Bean
//	@Autowired
//	public static ResourceLoaderBeanPostProcessor resourceLoaderBeanPostProcessor(
//	            AmazonS3Client amazonS3EncryptionClient) {
//	        return new ResourceLoaderBeanPostProcessor(amazonS3EncryptionClient);
//	}
//
//}