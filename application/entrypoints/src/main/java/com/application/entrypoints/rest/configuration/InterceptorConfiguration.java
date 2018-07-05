package com.application.entrypoints.rest.configuration;

import com.application.core.session.SessionUseCase;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.configuration.interceptors.AuthenticationInterceptor;
import com.application.entrypoints.rest.configuration.interceptors.CreateSessionAndUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Bean
    public CreateSessionAndUserInterceptor createSessionAndUserInterceptor(SessionUseCase s, UserUseCase u) {
        return new CreateSessionAndUserInterceptor(s, u);
    }

    @Bean
    AuthenticationInterceptor authenticationInterceptor(UserUseCase u) {
        return new AuthenticationInterceptor(u);
    }

    @Autowired
    public CreateSessionAndUserInterceptor createSessionAndUserInterceptor;

    @Autowired
    public AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry r) {
        r.addInterceptor(createSessionAndUserInterceptor);
        r.addInterceptor(authenticationInterceptor);
    }

}
