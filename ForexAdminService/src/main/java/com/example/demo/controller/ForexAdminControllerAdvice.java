package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.AdminServiceException;

@RestControllerAdvice
public class ForexAdminControllerAdvice {

	

    @ExceptionHandler(AdminServiceException.class)
    public ResponseEntity<String> handleControllerExceptionAction(AdminServiceException exp){
  	   return new ResponseEntity<String>(exp.getMessage() , HttpStatus.BAD_REQUEST);
  	  
  	  
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptionAction(Exception exp){
  	  return new ResponseEntity<String>(exp.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
  	  
    }

	
	
}
