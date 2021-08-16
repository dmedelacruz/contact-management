package com.dmedelacruz.contactmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(PersonNotFoundException exception) {
        exception.getErrorMessage().setCode(HttpStatus.NOT_FOUND.value());
        exception.getErrorMessage().setStatus(HttpStatus.NOT_FOUND.name());
        return new ResponseEntity<>(Map.of("error", exception.getErrorMessage()), HttpStatus.NOT_FOUND);
    }

}
