package com.application.configuration;

import com.application.core.dataproviders.category.CategoryDataMapper;
import com.application.core.dataproviders.category.CategoryRepository;
import com.application.core.dataproviders.poll.PollDataMapper;
import com.application.core.dataproviders.poll.PollRepository;
import com.application.core.dataproviders.user.UserDataMapper;
import com.application.core.dataproviders.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class DataProviderConfiguration {

    @Autowired
    private final PollRepository pollRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final UserRepository userRepository;

    @Bean
    public PollDataMapper pollDataMapper() {
        return new PollDataMapper(pollRepository, categoryRepository);
    }

    @Bean
    public CategoryDataMapper categoryDataMapper() {
        return new CategoryDataMapper(categoryRepository);
    }

    @Bean
    public UserDataMapper userDataMapper() {
        return new UserDataMapper(userRepository);
    }

}
