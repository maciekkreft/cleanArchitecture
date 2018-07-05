package com.application.entrypoints.rest.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.Cookie;

@Slf4j
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
        log.error(message);
    }

    public UnauthorizedException(Exception e) {
        this(e.getMessage());
    }
}
