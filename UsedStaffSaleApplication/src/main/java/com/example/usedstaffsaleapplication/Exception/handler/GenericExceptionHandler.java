package com.example.usedstaffsaleapplication.Exception.handler;

import com.example.usedstaffsaleapplication.Exception.CustomJwtException;
import com.example.usedstaffsaleapplication.Exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleEntityNotFoundException(EntityNotFoundException exception) {
        Map<String, String> errorResponsemap = new HashMap<>();
        errorResponsemap.put("error message", exception.getMessage());
        errorResponsemap.put("cause", exception.getDetails());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponsemap);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleEntityNotFoundException(Exception exception) {
        Map<String, String> errorResponsemap = new HashMap<>();
        errorResponsemap.put("error message", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponsemap);
    }
    @ExceptionHandler(CustomJwtException.class)
    public ResponseEntity<Map<String,String>> handleCustomJwtException(CustomJwtException exception) {
        Map<String, String> errorResponsemap = new HashMap<>();
        errorResponsemap.put("erroe message", exception.getMessage());
        errorResponsemap.put("error status",exception.getHttpStatus().toString() );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponsemap);

    }
}
