package com.yt.SmartTasker.exception;

public class InvalidPassword extends RuntimeException{

	private String message;

	public InvalidPassword(String message) {
//		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
