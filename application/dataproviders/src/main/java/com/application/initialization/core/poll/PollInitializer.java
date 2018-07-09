package com.application.initialization.core.poll;

import com.alibaba.fastjson.JSON;
import com.application.dataproviders.category.Category;
import com.application.dataproviders.category.CategoryRepository;
import com.application.dataproviders.poll.PollRepository;
import com.application.dataproviders.supplement.Supplement;
import com.application.dataproviders.supplement.SupplementRepository;
import com.application.initialization.core.Initializer;
import com.application.initialization.dataprovider.JsonFileHelper;
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
    private final SupplementRepository supplementRepository;
    private final String pollFilename;

    @Override
    @SneakyThrows
    public void initialize() {
        Map<String, Category> categoryByCode = StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(c -> c.getCode(), c -> c));

        Map<String, Supplement> supplementByCode = StreamSupport
                .stream(supplementRepository.findAll().spliterator(), false)
                .collect(Collectors.toMap(s -> s.getCode(), s -> s));

        String pollsJson = JsonFileHelper.getJson(pollFilename);
        PollsJson pollsJsonAsObject = JSON.parseObject(pollsJson, PollsJson.class);

        pollRepository.saveAll(PollConverter.toRows(
                pollsJsonAsObject,
                categoryByCode,
                supplementByCode
        ));
        log.info("Saved {} polls", pollRepository.count());
    }
}
