package com.application.configuration;

import com.application.core.book.BookDataGateway;
import com.application.core.book.BookUseCase;
import com.application.core.poll.PollDataGateway;
import com.application.core.poll.PollUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public BookUseCase bookUseCase(BookDataGateway bookDataGateway) {
        return new BookUseCase(bookDataGateway);
    }

    @Bean
    public PollUseCase pollUseCase(PollDataGateway pollDataGateway){
        return new PollUseCase(pollDataGateway);
    }
}
