package com.example.petdate.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// ControllerAdvice annotation to handle validation and exception
@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    //override the method
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request){
        // create a map to get errors stored
        Map<String, String> errors = new HashMap<>();
        // returns a list so we can use for each method with lambda expression
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            // get filed mathod that returns a field name
            String fieldName = ((FieldError) error).getField();
            // get the validation message from the error object
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        //
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }
}
