package com.application.configuration;

import com.application.core.dataproviders.book.BookDataMapper;
import com.application.core.dataproviders.book.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class DataProviderConfiguration {
    @Autowired
    private final BookRepository getBookRepository;

    @Bean
    public BookDataMapper getBookDataGateway() {
        return new BookDataMapper(getBookRepository);
    }

}
