package com.application.initialization.core.supplement;

import com.alibaba.fastjson.JSON;
import com.application.dataproviders.supplement.SupplementRepository;
import com.application.initialization.core.Initializer;
import com.application.initialization.dataprovider.JsonFileHelper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class SupplementInitializer implements Initializer {
    private final SupplementRepository repository;
    private final String filename;

    @Override
    @SneakyThrows
    public void initialize() {
        String json = JsonFileHelper.getJson(filename);
        SupplementsJson jsonAsObject = JSON.parseObject(json, SupplementsJson.class);
        repository.saveAll(SupplementConverter.toRows(jsonAsObject));
        log.info("Saved {} supplements", repository.count());
    }
}
