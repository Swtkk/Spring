package com.swietlik.swietlik.controller;

import com.swietlik.swietlik.model.Streamer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class StreamerExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StreamerErrorResponse> handleException(StreamerNotFoundException e){
        StreamerErrorResponse err = new StreamerErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(e.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<StreamerErrorResponse> handleException(RuntimeException e){
        StreamerErrorResponse err = new StreamerErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Failed to convert string to int");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
