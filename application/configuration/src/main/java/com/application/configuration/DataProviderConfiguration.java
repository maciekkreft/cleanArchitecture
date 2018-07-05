package com.application.configuration;

import com.application.dataproviders.category.CategoryDataMapper;
import com.application.dataproviders.category.CategoryRepository;
import com.application.dataproviders.poll.PollDataMapper;
import com.application.dataproviders.poll.PollRepository;
import com.application.dataproviders.session.SessionDataMapper;
import com.application.dataproviders.session.SessionRepository;
import com.application.dataproviders.sheet.SheetDataMapper;
import com.application.dataproviders.sheet.SheetRepository;
import com.application.dataproviders.user.UserDataMapper;
import com.application.dataproviders.user.UserRepository;
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

    @Autowired
    private final SheetRepository sheetRepository;

    @Autowired
    private final SessionRepository sessionRepository;

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

    @Bean
    public SheetDataMapper sheetDataMapper() {
        return new SheetDataMapper(sheetRepository, pollRepository, userRepository);
    }

    @Bean
    public SessionDataMapper sessionDataMapper() {
        return new SessionDataMapper(sessionRepository);
    }

}
