package com.application.entrypoints.rest.category;

import com.application.core.category.CategoryAlreadyExists;
import com.application.core.category.CategoryEntity;
import com.application.core.category.CategoryUseCase;
import com.application.entrypoints.rest.exceptions.ConflictException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryUseCase pollUseCase;

    @PostMapping
    public GetCategoryDto addCategory(@RequestBody @Valid AddCategoryDto dto) {
        try {
            return toDto(pollUseCase.addCategory(toEntity(dto)));
        } catch (CategoryAlreadyExists e) {
            log.error(Marker.ANY_MARKER, e);
            throw new ConflictException(e.getMessage());
        }
    }

    private GetCategoryDto toDto(CategoryEntity category) {
        return new GetCategoryDto(category.getId(), category.getCode(), category.getName());
    }

    private CategoryEntity toEntity(AddCategoryDto dto) {
        return new CategoryEntity(null, dto.getCode(), dto.getName());
    }

}

