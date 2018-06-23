package com.application.configuration;

import com.application.core.book.BookDataGateway;
import com.application.core.book.BookUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public BookUseCase getBookUseCase(BookDataGateway getBookDataGateway) {
        return new BookUseCase(getBookDataGateway);
    }
}
