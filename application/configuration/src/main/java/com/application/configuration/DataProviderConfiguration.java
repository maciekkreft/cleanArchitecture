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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class DataProviderConfiguration {

    @Bean
    public PollDataMapper pollDataMapper(PollRepository p, CategoryRepository c) {
        return new PollDataMapper(p, c);
    }

    @Bean
    public CategoryDataMapper categoryDataMapper(CategoryRepository c) {
        return new CategoryDataMapper(c);
    }

    @Bean
    public UserDataMapper userDataMapper(UserRepository u) {
        return new UserDataMapper(u);
    }

    @Bean
    public SheetDataMapper sheetDataMapper(SheetRepository s, PollRepository p, UserRepository u) {
        return new SheetDataMapper(s, p, u);
    }

    @Bean
    public SessionDataMapper sessionDataMapper(SessionRepository s) {
        return new SessionDataMapper(s);
    }

}
