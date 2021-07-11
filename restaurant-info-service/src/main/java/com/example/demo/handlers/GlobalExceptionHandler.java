package com.example.demo.handlers;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.model.ErrorHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public ErrorHandler  handleAllExceptions(Exception e, WebRequest request) {
	
		return new ErrorHandler(LocalDateTime.now(), e.getMessage(),request.getDescription(false));
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorHandler  handleNoElement(Exception e, WebRequest request) {
		
		return  new ErrorHandler(LocalDateTime.now(), "Err-10393-Element Not Found",request.getDescription(false));

	}
}
