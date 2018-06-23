package com.application.core.book;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BookUseCase {
    private final BookDataGateway getBookDataGateway;

    public List<Book> listAllBooks() {
        return getBookDataGateway.getAllBooks();
    }

    public Book addBook(Book book) {
        return getBookDataGateway.addBook(book);
    }
}
