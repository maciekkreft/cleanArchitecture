package com.application.core.book;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GetBookUseCase {
    private final GetBookDataGateway getBookDataGateway;

    public List<Book> listAllBooks() {
        return getBookDataGateway.getAllBooks();
    }
}
