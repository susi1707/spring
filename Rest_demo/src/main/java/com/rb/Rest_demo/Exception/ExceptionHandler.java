package com.rb.Rest_demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
@org.springframework.web.bind.annotation.ExceptionHandler(value = {CloudVendorException.class})
    public ResponseEntity<Object> HandlerNotFoundException(
       CloudVendorException cloudVendorException){
        ExceptionDetail details = new ExceptionDetail(
                cloudVendorException.getMessage(),
                cloudVendorException.getCause(),
                HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

}
