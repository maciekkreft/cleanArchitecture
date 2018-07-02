package com.application.core.initialization.core.category;

import com.alibaba.fastjson.JSON;
import com.application.core.initialization.core.Initializer;
import com.application.core.initialization.dataprovider.JsonFileHelper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

@Slf4j
@Data
public class CategoryInitializer implements Initializer {
    private final CrudRepository repository;
    private final String filename;

    @Override
    @SneakyThrows
    public void initialize() {
        String json = JsonFileHelper.getJson(filename);
        CategoriesJson jsonAsObject = JSON.parseObject(json, CategoriesJson.class);
        repository.saveAll(CategoryConverter.toRows(jsonAsObject));
        log.info("Saved {} categories", repository.count());
    }
}
