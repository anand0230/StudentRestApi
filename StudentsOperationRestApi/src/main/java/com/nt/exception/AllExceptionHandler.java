package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler {
	
	

	@ExceptionHandler(StudentNotFound.class)
	public ProblemDetail handleStudentNotFound(StudentNotFound ex) {	
	  return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());	
	}
	


}
