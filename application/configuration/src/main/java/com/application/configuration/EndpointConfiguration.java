package com.application.configuration;

import com.application.core.book.GetBookUseCase;
import com.application.entrypoints.rest.book.GetBookController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public GetBookController getBookController(GetBookUseCase getBookUseCase) {
        return new GetBookController(getBookUseCase);
    }
}
