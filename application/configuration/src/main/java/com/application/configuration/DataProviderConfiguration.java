package com.application.configuration;

import com.application.core.dataproviders.book.GetBookDataMapper;
import com.application.core.dataproviders.book.GetBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class DataProviderConfiguration {
    @Autowired
    private final GetBookRepository getBookRepository;

    @Bean
    public GetBookDataMapper getBookDataGateway() {
        return new GetBookDataMapper(getBookRepository);
    }

}
