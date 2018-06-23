package com.application.configuration;

import com.application.core.book.BookUseCase;
import com.application.entrypoints.rest.book.BookController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public BookController getBookController(BookUseCase getBookUseCase) {
        return new BookController(getBookUseCase);
    }
}
