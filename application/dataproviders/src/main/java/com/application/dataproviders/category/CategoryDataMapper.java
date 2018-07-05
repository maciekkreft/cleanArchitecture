package com.application.dataproviders.category;

import com.application.core.category.CategoryDataGateway;
import com.application.core.category.CategoryEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public List<CategoryEntity> findAllCategories() {
        return toEntity(categoryRepository.findAll());
    }


    private List<CategoryEntity> toEntity(Iterable<Category> categories) {
       return StreamSupport.stream(categories.spliterator(), false)
               .map(c -> toEntity(c))
               .collect(Collectors.toList());
    }

    private CategoryEntity toEntity(Category c) {
        return new CategoryEntity(c.getCode(), c.getName());
    }

    private Category toRow(CategoryEntity category) {
        return new Category(category.getCode(), category.getName());
    }
}
