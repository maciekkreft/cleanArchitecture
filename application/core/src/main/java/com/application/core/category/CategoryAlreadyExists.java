package com.application.core.category;

public class CategoryAlreadyExists extends RuntimeException {
    public CategoryAlreadyExists(String categoryCode) {
        super(String.format("Category %s already exists", categoryCode));
    }
}
