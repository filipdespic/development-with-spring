package com.example.demo.rest;

import com.example.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

        var response = new StudentErrorResponse();

        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {

        var response = new StudentErrorResponse();

        response.setMessage(e.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
