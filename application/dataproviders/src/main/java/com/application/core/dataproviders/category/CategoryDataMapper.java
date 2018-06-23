package com.application.core.dataproviders.category;

import com.application.core.category.CategoryDataGateway;
import com.application.core.category.CategoryEntity;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CategoryDataMapper implements CategoryDataGateway {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        return toEntity(categoryRepository.save(toRow(category)));
    }

    @Override
    public boolean exists(String code) {
        return categoryRepository.findByCode(code) != null;
    }

    private CategoryEntity toEntity(Category r) {
        return new CategoryEntity(r.getId(), r.getCode(), r.getName());
    }

    private Category toRow(CategoryEntity category) {
        return new Category(category.getCode(), category.getName());
    }
}
