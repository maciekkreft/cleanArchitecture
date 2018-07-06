package com.application.configuration;

import com.application.core.session.SessionUseCase;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.interceptors.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EndpointInterceptorConfiguration {
    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }

    @Bean
    public CreateUserCookieInterceptor createUserCookieInterceptor(UserUseCase u, SessionUseCase s) {
        return new CreateUserCookieInterceptor(u, s);
    }

    @Bean
    public CreateSessionCookieInterceptor createSessionCookieInterceptor(SessionUseCase s) {
        return new CreateSessionCookieInterceptor(s);
    }

    @Bean
    public AuthenticationInterceptor authenticationInterceptor(UserUseCase u) {
        return new AuthenticationInterceptor(u);
    }

    @Bean
    public InterceptorExceptionHandler globalExceptionHandler() {
        return new InterceptorExceptionHandler();
    }

    @Bean
    public WebMvcConfigurer interceptorConfiguration(
            LoggingInterceptor l,
            CreateUserCookieInterceptor u,
            CreateSessionCookieInterceptor s,
            AuthenticationInterceptor a
    ) {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry r) {
                r.addInterceptor(l);
                r.addInterceptor(s);
                r.addInterceptor(u);
                r.addInterceptor(a);
            }
        };
    }

}
