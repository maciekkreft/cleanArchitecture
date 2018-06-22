package com.application.configuration;

import com.application.core.book.GetBookDataGateway;
import com.application.core.book.GetBookUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public GetBookUseCase getBookUseCase(GetBookDataGateway getBookDataGateway) {
        return new GetBookUseCase(getBookDataGateway);
    }
}
