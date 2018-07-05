package com.application.initialization.configuration;

import com.application.dataproviders.category.CategoryRepository;
import com.application.dataproviders.poll.PollRepository;
import com.application.initialization.core.DbInitializer;
import com.application.initialization.core.category.CategoryInitializer;
import com.application.initialization.core.poll.PollInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DbInitializerConfiguration {
    private static final String CATEGORIES_EN_JSON = "categories_en.json";
    private static final String POLLS_EN_JSON = "polls_en.json";

    @Bean
    public CategoryInitializer categoryInitializer(CategoryRepository categoryRepository) {
        return new CategoryInitializer(categoryRepository, CATEGORIES_EN_JSON);
    }

    @Bean
    public PollInitializer pollInitializer(CategoryRepository categoryRepository, PollRepository pollRepository) {
        return new PollInitializer(categoryRepository, pollRepository, POLLS_EN_JSON);
    }

    @Bean
    public DbInitializer mainInitializer(CategoryInitializer categoryInitializer, PollInitializer pollInitializer) {
        return new DbInitializer(Arrays.asList(
                categoryInitializer,
                pollInitializer
        ));
    }

}
