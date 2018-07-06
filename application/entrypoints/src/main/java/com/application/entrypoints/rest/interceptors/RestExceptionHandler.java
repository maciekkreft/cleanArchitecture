package com.application.entrypoints.rest.interceptors;

import com.alibaba.fastjson.JSON;
import com.application.entrypoints.rest.exceptions.RestException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Data
    private static class Error {
        private final String path;
        private final String message;
        private final String status;
        private final String reason;

    }

    @ExceptionHandler(value = RestException.class)
    public void handle(
            HttpServletRequest req,
            HttpServletResponse res,
            Exception ex
    ) throws IOException {
        HttpStatus status = ex.getClass().getAnnotation(ResponseStatus.class).value();
        Error error = new Error(
                req.getRequestURI(),
                ex.getMessage(),
                status.toString(),
                status.getReasonPhrase()
        );
        String json = JSON.toJSONString(error);
        res.setContentType("application/json");
        res.setStatus(status.value());
        res.getWriter().write(json);
    }
}
