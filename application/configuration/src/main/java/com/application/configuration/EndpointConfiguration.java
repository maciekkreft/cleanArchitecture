package com.application.configuration;

import com.application.core.book.BookUseCase;
import com.application.core.poll.PollUseCase;
import com.application.entrypoints.rest.book.BookController;
import com.application.entrypoints.rest.category.CategoryController;
import com.application.entrypoints.rest.poll.PollController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public BookController bookController(BookUseCase bookUseCase) {
        return new BookController(bookUseCase);
    }

    @Bean
    public PollController pollController(PollUseCase pollUseCase) {
        return new PollController(pollUseCase);
    }

    @Bean
    public CategoryController categoryController(PollUseCase pollUseCase) {
        return new CategoryController(pollUseCase);
    }
}
