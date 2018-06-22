package com.application.entrypoints.rest.book;

import com.application.core.book.Book;
import com.application.core.book.GetBookUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController("/books")
public class GetBookController {

    private final GetBookUseCase getBookUseCase;

    @GetMapping
    public List<BookDto> listAllBooks() {
        return toDto(getBookUseCase.listAllBooks());
    }

    private List<BookDto> toDto(List<Book> books) {
        return books.stream()
                .map(book -> new BookDto(book.getTitle()))
                .collect(Collectors.toList());
    }

}

