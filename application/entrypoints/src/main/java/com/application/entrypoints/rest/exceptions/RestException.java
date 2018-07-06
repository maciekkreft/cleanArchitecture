package com.application.entrypoints.rest.exceptions;

public class RestException extends RuntimeException {
    public RestException(String message) {
        super(message);
    }
}
