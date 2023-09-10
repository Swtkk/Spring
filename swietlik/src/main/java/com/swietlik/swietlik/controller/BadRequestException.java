package com.swietlik.swietlik.controller;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
    public BadRequestException() {
    }




}
