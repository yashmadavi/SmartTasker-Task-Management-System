package com.yt.SmartTasker.exception;

public class InvalidEmail extends RuntimeException{

	private String message ;

	public InvalidEmail(String message) {
		//super(); if we are not using super calling statement then must and should use getMessage()
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		//return super.getMessage();
		// the getMessage() will call the parent class Throwable is takes some time to load
		return message;
		// it return our own message in faster way

	}
	
}
