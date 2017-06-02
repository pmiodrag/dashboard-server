package com.twinsoft.service.storage;

public class FileAmazonException extends RuntimeException {

	private static final long serialVersionUID = 2468434988680850339L;	
	
	public FileAmazonException(String msg, Throwable throwable){
		super(msg, throwable);
	}
}