package com.application.core.initialization.core.category;

import com.application.core.dataproviders.category.Category;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter {
    @NonNull
    public static List<Category> toRows(CategoriesJson jsonAsObject) {
        return jsonAsObject.getCategories().stream()
                .map(c -> new Category(c.getCode(), c.getName()))
                .collect(Collectors.toList());
    }
}
