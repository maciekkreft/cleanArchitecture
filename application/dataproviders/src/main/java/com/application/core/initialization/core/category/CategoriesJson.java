package com.application.core.initialization.core.category;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriesJson {
    private final List<CategoryJson> categories = new ArrayList<>();

    @Data
    public static class CategoryJson {
        private final String code;
        private final String name;
    }
}


