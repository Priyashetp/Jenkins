package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.UserServiceException;

@RestControllerAdvice
public class UserServiceAdviceController {

	

    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<String> handleControllerExceptionAction(UserServiceException exp){
  	   return new ResponseEntity<String>(exp.getMessage() , HttpStatus.BAD_REQUEST);
  	  
  	  
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptionAction(Exception exp){
  	  return new ResponseEntity<String>(exp.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
  	  
    }



}
