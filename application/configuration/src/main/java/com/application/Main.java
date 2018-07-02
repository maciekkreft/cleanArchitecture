package com.application;

import com.application.core.initialization.configuration.InitializerConfiguration;
import com.application.core.initialization.core.DbInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.application.configuration")
@Import(InitializerConfiguration.class)
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        DbInitializer dbInitializer = context.getBean(DbInitializer.class);
        dbInitializer.initialize();
    }

}
