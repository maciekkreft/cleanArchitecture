package com.application.entrypoints.rest.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends RestException {
    public ConflictException(Exception e) {
        super(e.getMessage());
        log.error(e.getMessage(), e);
    }
}
