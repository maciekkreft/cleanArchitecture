package com.application.entrypoints.rest.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    public BadRequestException(Exception e) {
        super(e.getMessage());
        log.error(Marker.ANY_MARKER, e);
    }
}
