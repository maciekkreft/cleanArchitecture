package com.application.entrypoints.rest.core.init;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/init")
public class InitController {

    @GetMapping
    public String getInit() {
        return "{\"status\": \"true\"}";
    }

    @PostMapping
    public String createInit() {
        return "{\"status\": \"true\"}";
    }
}
