package com.application.entrypoints.rest.exceptions;

import com.application.core.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RestException {
    public UnauthorizedException(ValidationException e) {
        super(e.getMessage());
        log.error(e.getMessage(), e);
    }
}
