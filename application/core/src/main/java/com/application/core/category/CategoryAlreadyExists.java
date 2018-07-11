package com.application.core.category;

import com.application.common.ValidationException;

public class CategoryAlreadyExists extends ValidationException {
    public CategoryAlreadyExists(String categoryCode) {
        super(String.format("Category %s already exists", categoryCode));
    }
}
