package com.application.entrypoints.rest.interceptors;

import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
public class CorsHelper {
    private final String origin;

    public void addCorsSupport(HttpServletResponse res) {
        res.addHeader("Access-Control-Allow-Origin", origin);
        res.addHeader("Access-Control-Allow-Credentials", "true");
    }
}
