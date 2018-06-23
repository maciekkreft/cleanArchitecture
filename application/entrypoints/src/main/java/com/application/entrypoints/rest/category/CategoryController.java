package com.application.entrypoints.rest.category;

import com.application.core.poll.Category;
import com.application.core.poll.PollUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final PollUseCase pollUseCase;

    @PostMapping
    public GetCategoryDto addCategory(@RequestBody @Valid AddCategoryDto dto) {
        return toDto(pollUseCase.addCategory(toEntity(dto)));
    }

    private GetCategoryDto toDto(Category category) {
        return new GetCategoryDto(category.getId(), category.getCode(), category.getName());
    }

    private Category toEntity(AddCategoryDto dto) {
        return new Category(null, dto.getCode(), dto.getName());
    }

}

