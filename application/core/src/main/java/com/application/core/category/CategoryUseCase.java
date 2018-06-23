package com.application.core.category;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryUseCase {
    private final CategoryDataGateway categoryDataGateway;

    public CategoryEntity addCategory(CategoryEntity category) {
        if (categoryDataGateway.exists(category.getCode())) {
            throw new CategoryAlreadyExists(category.getCode());
        }
        return categoryDataGateway.addCategory(category);
    }
}
