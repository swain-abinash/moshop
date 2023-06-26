package com.moshop.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VariantNotFoundException extends RuntimeException{
//@ExceptionHandler(VariantNotFoundException.class)
//public ResponseEntity<String> handleVariantNotFoundException(VariantNotFoundException ex) {
//    String errorMessage = "Variant not found: " + ex.getMessage();
//    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
//}

@ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception exception){
    return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), "Error");
    }
}
