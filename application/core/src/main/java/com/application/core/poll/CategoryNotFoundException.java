package com.application.core.poll;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String categoryCode) {
        super(String.format("Category %s does not exists", categoryCode));
    }
}
