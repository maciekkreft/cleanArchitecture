package com.application.entrypoints.rest.book;

import com.application.core.book.Book;
import com.application.core.book.BookUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController("/books")
public class BookController {
    private final BookUseCase bookUseCase;

    @GetMapping
    public List<GetBookDto> listAllBooks() {
        return toDto(bookUseCase.listAllBooks());
    }

    @PostMapping
    public GetBookDto addBook(@RequestBody @Valid AddBookDto dto) {
        return toDto(bookUseCase.addBook(toEntity(dto)));
    }

    private GetBookDto toDto(Book book) {
        return new GetBookDto(book.getId(), book.getTitle());
    }

    private List<GetBookDto> toDto(List<Book> books) {
        return books.stream()
                .map(book -> toDto(book))
                .collect(Collectors.toList());
    }

    private Book toEntity(AddBookDto dto) {
        return new Book(null, dto.getTitle());
    }

}

