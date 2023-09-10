package com.swietlik.swietlik.controller;

import java.rmi.StubNotFoundException;

public class StreamerNotFoundException extends RuntimeException {
    public StreamerNotFoundException(String message) {
        super(message);
    }

    public StreamerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StreamerNotFoundException(Throwable cause) {
        super(cause);
    }

    public StreamerNotFoundException() {

    }
}
