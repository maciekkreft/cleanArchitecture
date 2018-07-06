package com.application.entrypoints.rest.interceptors;

import com.alibaba.fastjson.JSON;
import com.application.entrypoints.rest.exceptions.RestException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestControllerAdvice
public class InterceptorExceptionHandler {

    @Data
    private static class Error {
        private final String timestamp;
        private final String status;
        private final String error;
        private final String message;
        private final String path;
    }

    @ExceptionHandler(value = RestException.class)
    public void handle(
            HttpServletRequest req,
            HttpServletResponse res,
            Exception ex
    ) throws IOException {
        HttpStatus status = ex.getClass().getAnnotation(ResponseStatus.class).value();
        Error error = new Error(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
                status.toString(),
                status.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );
        String json = JSON.toJSONString(error);
        res.setContentType("application/json");
        res.setStatus(status.value());
        res.getWriter().write(json);
    }
}
