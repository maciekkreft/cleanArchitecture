package com.application.entrypoints.rest.category;

import com.application.core.category.CategoryAlreadyExists;
import com.application.core.category.CategoryEntity;
import com.application.core.category.CategoryUseCase;
import com.application.entrypoints.rest.exceptions.ConflictException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryUseCase categoryUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetCategoryDto addCategory(@RequestBody @Valid AddCategoryDto dto) {
        try {
            return toDto(categoryUseCase.addCategory(toEntity(dto)));
        } catch (CategoryAlreadyExists e) {
            throw new ConflictException(e);
        }
    }

    @GetMapping
    List<GetCategoryDto> listAllCategories() {
        return toDto(categoryUseCase.listAllCategories());
    }

    private List<GetCategoryDto> toDto(Iterable<CategoryEntity> categories) {
        return StreamSupport.stream(categories.spliterator(), false)
                .map(c -> toDto(c))
                .collect(Collectors.toList());
    }

    private GetCategoryDto toDto(CategoryEntity category) {
        return new GetCategoryDto(category.getCode(), category.getName());
    }

    private CategoryEntity toEntity(AddCategoryDto dto) {
        return new CategoryEntity(dto.getCode(), dto.getName());
    }

}

