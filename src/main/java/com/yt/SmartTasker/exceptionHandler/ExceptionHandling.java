package com.yt.SmartTasker.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yt.SmartTasker.exception.EmailNotFound;
import com.yt.SmartTasker.exception.IdNotFound;
import com.yt.SmartTasker.exception.InvalidEmail;
import com.yt.SmartTasker.exception.InvalidPassword;
import com.yt.SmartTasker.util.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandling {

	ResponseStructure<String> structure = new ResponseStructure<>();
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> userIdNotFound(IdNotFound idNotFound){
		
		structure.setMessage("User id not Found");
		structure.setData(idNotFound.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidEmail.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFound(InvalidEmail invalidEmail){
		
		structure.setMessage("email id is invalid");
		structure.setData(invalidEmail.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidPassword.class)
	public ResponseEntity<ResponseStructure<String>> passwordInvalid(InvalidPassword incorrectPassword){
		
		structure.setData(incorrectPassword.getMessage());
		structure.setMessage("Password is invalid");
		structure.setStatusCode(HttpStatus.FORBIDDEN.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFound(EmailNotFound notFound){
		
		structure.setData(notFound.getMessage());
		structure.setMessage("Email is not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure , HttpStatus.NOT_FOUND);
	}
}
