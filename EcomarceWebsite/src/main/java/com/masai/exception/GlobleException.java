package com.masai.exception;

import java.time.LocalDateTime;
import java.util.logging.Handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobleException {
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> CustomerExceptionHandler(CustomerException ex,WebRequest re){
		
		return new ResponseEntity<MyError>(new MyError(ex.getMessage(),re.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ItemsException.class)
	public ResponseEntity<MyError> ItemsExceptionHandler(ItemsException ex,WebRequest re){
		
		return new ResponseEntity<MyError>(new MyError(ex.getMessage(),re.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyError> OrderExceptionHandler(OrderException ex,WebRequest re){
		
		return new ResponseEntity<MyError>(new MyError(ex.getMessage(),re.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyError> LoginExceptionHandler(LoginException ex,WebRequest re){
		return new ResponseEntity<MyError>(new MyError(ex.getMessage(),re.getDescription(false),LocalDateTime.now()),HttpStatus.OK);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyError> AdminExceptionHandler(AdminException ex,WebRequest re){
		
		return new ResponseEntity<MyError>(new MyError(ex.getMessage(),re.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> AllExceptionHandler(Exception ex,WebRequest re){
		
		return new ResponseEntity<MyError>(new MyError(ex.getMessage(),re.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
		
	}
	
}
