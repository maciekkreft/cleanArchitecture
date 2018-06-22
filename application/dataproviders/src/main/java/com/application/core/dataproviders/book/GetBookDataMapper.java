package com.application.core.dataproviders.book;

import com.application.core.book.Book;
import com.application.core.book.GetBookDataGateway;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class GetBookDataMapper implements GetBookDataGateway {
    private final GetBookRepository getBookRepository;

    @Override
    public List<Book> getAllBooks() {
        return toEntity(getBookRepository.findAll());
    }

    private List<Book> toEntity(Iterable<BookRow> bookRows) {
        return StreamSupport.stream(bookRows.spliterator(), false)
                .map(r -> new Book(r.getTitle()))
                .collect(Collectors.toList());
    }
}
