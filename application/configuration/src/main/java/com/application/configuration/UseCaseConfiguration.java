package com.application.configuration;

import com.application.core.category.CategoryDataGateway;
import com.application.core.category.CategoryUseCase;
import com.application.core.poll.PollDataGateway;
import com.application.core.poll.PollUseCase;
import com.application.core.session.SessionDataGateway;
import com.application.core.session.SessionUseCase;
import com.application.core.sheet.SheetDataGateway;
import com.application.core.sheet.SheetUseCase;
import com.application.core.user.UserDataGateway;
import com.application.core.user.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public PollUseCase pollUseCase(PollDataGateway pollDataGateway,
                                   CategoryDataGateway categoryDataGateway
    ) {
        return new PollUseCase(pollDataGateway, categoryDataGateway);
    }

    @Bean
    public CategoryUseCase categoryUseCase(CategoryDataGateway categoryDataGateway) {
        return new CategoryUseCase(categoryDataGateway);
    }

    @Bean
    public UserUseCase userUseCase(UserDataGateway userDataGateway,
                                   SessionUseCase sessionUseCase
    ) {
        return new UserUseCase(userDataGateway, sessionUseCase);
    }

    @Bean
    public SheetUseCase sheetUseCase(SheetDataGateway sheetDataGateway,
                                     PollDataGateway pollDataGateway,
                                     UserDataGateway userDataGateway
    ) {
        return new SheetUseCase(sheetDataGateway, pollDataGateway, userDataGateway);
    }

    @Bean
    public SessionUseCase sessionUseCase(SessionDataGateway sessionDataGateway) {
        return new SessionUseCase(sessionDataGateway);
    }
}
