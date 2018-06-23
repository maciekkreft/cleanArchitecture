package com.application.core.category;

import java.util.List;

public interface CategoryDataGateway {
    CategoryEntity addCategory(CategoryEntity category);
    boolean exists(String code);
    List<CategoryEntity> findAllCategories();
}
