package com.jsp.spring.springboot_first_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHnadler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse>handleResourceNotFound(ResourceNotFoundException exception){
		ErrorResponse error=new ErrorResponse(
				404,
				"Not Found",
				exception.getMessage()
				);
		  return new ResponseEntity<>(
				  error,
				  HttpStatus.NOT_FOUND);
				 
	}
}
