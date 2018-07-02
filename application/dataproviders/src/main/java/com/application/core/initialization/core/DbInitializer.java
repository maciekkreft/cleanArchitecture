package com.application.core.initialization.core;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class DbInitializer {
    private final List<Initializer> initializerList;

    public void initialize() {
        log.info("Database Initializer started");
        initializerList.forEach(i -> i.initialize());
        log.info("Database Initializer finished");
    }
}
