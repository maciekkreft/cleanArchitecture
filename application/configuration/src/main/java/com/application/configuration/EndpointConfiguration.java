package com.application.configuration;

import com.application.core.category.CategoryUseCase;
import com.application.core.poll.PollUseCase;
import com.application.core.sheet.SheetUseCase;
import com.application.core.supplement.SupplementUseCase;
import com.application.entrypoints.rest.core.InitController;
import com.application.entrypoints.rest.core.category.CategoryController;
import com.application.entrypoints.rest.core.poll.PollController;
import com.application.entrypoints.rest.core.sheet.SheetController;
import com.application.entrypoints.rest.core.supplement.SupplementController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public PollController pollController(PollUseCase p) {
        return new PollController(p);
    }

    @Bean
    public CategoryController categoryController(CategoryUseCase c) { return new CategoryController(c); }

    @Bean
    public SheetController sheetController(SheetUseCase s) {
        return new SheetController(s);
    }

    @Bean
    public SupplementController supplementController(SupplementUseCase s) {
        return new SupplementController(s);
    }

    @Bean
    public InitController initController() {
        return new InitController();
    }
}
