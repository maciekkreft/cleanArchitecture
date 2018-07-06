package com.application.configuration;

import com.application.core.session.SessionUseCase;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.interceptors.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class EndpointInterceptorConfiguration {
    @Bean
    public LoggingInterceptor loggingInterceptor(){
        return new LoggingInterceptor();
    }

    @Bean
    public CreateUserCookieInterceptor createUserCookieInterceptor(UserUseCase u) {
        return new CreateUserCookieInterceptor(u);
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
    public RestExceptionHandler globalExceptionHandler() {
        return new RestExceptionHandler();
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
