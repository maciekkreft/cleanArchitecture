package com.application.core.dataproviders.book;

import com.application.core.book.Book;
import com.application.core.book.BookDataGateway;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class BookDataMapper implements BookDataGateway {
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return toEntity(bookRepository.findAll());
    }

    @Override
    public Book addBook(Book book) {
        return toEntity(bookRepository.save(toRow(book)));
    }

    private Book toEntity(BookRow bookRow) {
        return new Book(bookRow.getId(), bookRow.getTitle());
    }

    private List<Book> toEntity(Iterable<BookRow> bookRows) {
        return StreamSupport.stream(bookRows.spliterator(), false)
                .map(bookRow -> toEntity(bookRow))
                .collect(Collectors.toList());
    }

    private BookRow toRow(Book book) {
        return new BookRow(book.getTitle());
    }
}
