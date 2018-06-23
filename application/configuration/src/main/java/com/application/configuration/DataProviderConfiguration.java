package com.application.configuration;

import com.application.core.dataproviders.book.BookDataMapper;
import com.application.core.dataproviders.book.BookRepository;
import com.application.core.dataproviders.poll.CategoryRepository;
import com.application.core.dataproviders.poll.PollDataMapper;
import com.application.core.dataproviders.poll.PollRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AllArgsConstructor
@Configuration
public class DataProviderConfiguration {
    @Autowired
    private final BookRepository bookRepository;

    @Autowired
    private final PollRepository pollRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Bean
    public BookDataMapper bookDataGateway() {
        return new BookDataMapper(bookRepository);
    }

    @Bean
    public PollDataMapper pollDataMapper() {
        return new PollDataMapper(pollRepository, categoryRepository);
    }

}
