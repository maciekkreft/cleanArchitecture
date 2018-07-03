package com.application.core.initialization.core.poll;

import com.alibaba.fastjson.JSON;
import com.application.core.dataproviders.category.Category;
import com.application.core.dataproviders.category.CategoryRepository;
import com.application.core.dataproviders.poll.PollRepository;
import com.application.core.initialization.core.Initializer;
import com.application.core.initialization.dataprovider.JsonFileHelper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Data
@Transactional
public class PollInitializer implements Initializer {
    private final CategoryRepository categoryRepository;
    private final PollRepository pollRepository;
    private final String pollFilename;

    @Override
    @SneakyThrows
    public void initialize() {
        Map<String, Category> categoryByCode = StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(c -> c.getCode(), c -> c));

        String pollsJson = JsonFileHelper.getJson(pollFilename);
        PollsJson pollsJsonAsObject = JSON.parseObject(pollsJson, PollsJson.class);

        pollRepository.saveAll(PollConverter.toRows(pollsJsonAsObject, categoryByCode));
        log.info("Saved {} polls", pollRepository.count());
    }
}