package com.digitalinnovation.salas.de.reuniao.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import javax.xml.crypto.Data;
import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler (ResourceNotFoundException.class)
    public ResponseEntity<?> responseEntity(ResourceNotFoundException rnfe , WebRequest request){
        MyErrorDetails myErrorDetails = new MyErrorDetails(new Date() , rnfe.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(myErrorDetails , HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception e , WebRequest request){
        MyErrorDetails myErrorDetails = new MyErrorDetails(new Date() , e.getMessage(), request.getDescription(false));

         return new ResponseEntity<>(myErrorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
