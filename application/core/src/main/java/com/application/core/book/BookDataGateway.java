package com.application.core.book;

import java.util.List;

public interface BookDataGateway {
    List<Book> getAllBooks();
    Book addBook(Book book);
}
