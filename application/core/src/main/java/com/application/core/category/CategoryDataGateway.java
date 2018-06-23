package com.application.core.category;

public interface CategoryDataGateway {
    CategoryEntity addCategory(CategoryEntity category);
    boolean exists(String code);
}
