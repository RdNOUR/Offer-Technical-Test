package com.offertechnicaltest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = {ApplicationRequestException.class})
    public ResponseEntity<Object> handleApiRequestException_BAD_REQUEST(ApplicationRequestException e){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApplicationCustomException exFail = new ApplicationCustomException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(exFail, badRequest);
    }
}