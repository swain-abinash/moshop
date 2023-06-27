package com.moshop.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VariantNotFoundException extends RuntimeException {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(500), exception.getMessage());
    }
}
