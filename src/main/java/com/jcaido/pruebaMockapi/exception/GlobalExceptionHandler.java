package com.jcaido.pruebaMockapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ErrorDatails> handleResourceAlreadyExistException(ResourceAlreadyExistException exception, WebRequest webRequest) {
        ErrorDatails errorDatails = new ErrorDatails(exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(errorDatails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDatails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorDatails errorDatails = new ErrorDatails(exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity<>(errorDatails, HttpStatus.NOT_FOUND);
    }
}
