package com.application.core.poll;

import com.application.core.ValidationException;

public class CategoryNotFoundException extends ValidationException {
    public CategoryNotFoundException(String categoryCode) {
        super(String.format("Category %s does not exists", categoryCode));
    }
}
