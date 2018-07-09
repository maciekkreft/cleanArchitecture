package com.application.configuration;

import com.application.core.category.CategoryUseCase;
import com.application.core.poll.PollUseCase;
import com.application.core.sheet.SheetUseCase;
import com.application.entrypoints.rest.core.InitController;
import com.application.entrypoints.rest.core.category.CategoryController;
import com.application.entrypoints.rest.core.poll.PollController;
import com.application.entrypoints.rest.core.sheet.SheetController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public PollController pollController(PollUseCase pollUseCase) {
        return new PollController(pollUseCase);
    }

    @Bean
    public CategoryController categoryController(CategoryUseCase categoryUseCase) { return new CategoryController(categoryUseCase); }

    @Bean
    public SheetController sheetController(SheetUseCase sheetUseCase) {
        return new SheetController(sheetUseCase);
    }

    @Bean
    public InitController initController() {
        return new InitController();
    }
}
