package com.application.configuration;

import com.application.core.category.CategoryDataGateway;
import com.application.core.category.CategoryUseCase;
import com.application.core.poll.PollDataGateway;
import com.application.core.poll.PollUseCase;
import com.application.core.result.ResultUseCase;
import com.application.core.session.SessionDataGateway;
import com.application.core.session.SessionUseCase;
import com.application.core.sheet.SheetDataGateway;
import com.application.core.sheet.SheetUseCase;
import com.application.core.supplement.SupplementDataGateway;
import com.application.core.supplement.SupplementUseCase;
import com.application.core.user.UserDataGateway;
import com.application.core.user.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {
    @Bean
    public PollUseCase pollUseCase(PollDataGateway p, CategoryDataGateway c) {
        return new PollUseCase(p, c);
    }

    @Bean
    public CategoryUseCase categoryUseCase(CategoryDataGateway c) {
        return new CategoryUseCase(c);
    }

    @Bean
    public UserUseCase userUseCase(UserDataGateway u, SessionUseCase s) {
        return new UserUseCase(u, s);
    }

    @Bean
    public SheetUseCase sheetUseCase(SheetDataGateway s, PollDataGateway p, UserDataGateway u) {
        return new SheetUseCase(s, p, u);
    }

    @Bean
    public SupplementUseCase supplementUseCase(SupplementDataGateway s) {
        return new SupplementUseCase(s);
    }

    @Bean
    public SessionUseCase sessionUseCase(SessionDataGateway s) {
        return new SessionUseCase(s);
    }

    @Bean
    public ResultUseCase resultUseCase(SheetDataGateway s, PollDataGateway p) {
        return new ResultUseCase(s, p);
    }
}
