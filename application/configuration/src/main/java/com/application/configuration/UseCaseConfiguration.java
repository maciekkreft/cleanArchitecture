package com.application.configuration;

import com.application.core.category.CategoryDataGateway;
import com.application.core.category.CategoryUseCase;
import com.application.core.poll.PollDataGateway;
import com.application.core.poll.PollUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public PollUseCase pollUseCase(PollDataGateway pollDataGateway, CategoryDataGateway categoryDataGateway) {
        return new PollUseCase(pollDataGateway, categoryDataGateway);
    }

    @Bean
    public CategoryUseCase categoryUseCase(CategoryDataGateway categoryDataGateway) {
        return new CategoryUseCase(categoryDataGateway);
    }
}
