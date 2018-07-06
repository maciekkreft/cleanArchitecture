package com.application.initialization.configuration;

import com.application.dataproviders.category.CategoryRepository;
import com.application.dataproviders.poll.PollRepository;
import com.application.dataproviders.session.SessionRepository;
import com.application.initialization.core.DbInitializer;
import com.application.initialization.core.category.CategoryInitializer;
import com.application.initialization.core.poll.PollInitializer;
import com.application.initialization.core.user.UserInitializer;
import com.application.initialization.core.user.UserWithCustomIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DbInitializerConfiguration {

    @Bean
    public CategoryInitializer categoryInitializer(CategoryRepository c) {
        return new CategoryInitializer(c, "categories_en.json");
    }

    @Bean
    public PollInitializer pollInitializer(CategoryRepository c, PollRepository p) {
        return new PollInitializer(c, p, "polls_en.json");
    }

    @Autowired
    public UserWithCustomIdRepository userWithCustomIdRepository;

    @Bean
    public UserInitializer userInitializer(UserWithCustomIdRepository u, SessionRepository s) {
        return new UserInitializer(u, s);
    }

    @Bean
    public DbInitializer mainInitializer(
            CategoryInitializer c,
            PollInitializer p,
            UserInitializer u
    ) {
        return new DbInitializer(Arrays.asList(
                c, p, u
        ));
    }

}
