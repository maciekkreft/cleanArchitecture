package com.application.initialization;

import com.application.initialization.configuration.DbInitializerConfiguration;
import com.application.initialization.core.DbInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EntityScan(basePackages = "com.application.core.dataproviders")
@EnableJpaRepositories(basePackages = "com.application.core.dataproviders")
@Import(DbInitializerConfiguration.class)
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);
        ctx.getBean(DbInitializer.class).initialize();
    }

}
