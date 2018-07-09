package com.application.entrypoints.rest.core.poll;

import com.application.entrypoints.rest.core.category.GetCategoryDto;
import lombok.Data;

import java.util.List;

@Data
class GetPollDto {
    private final String code;
    private final String name;
    private final GetCategoryDto category;
    private final List<String> questions;
    private final int mediumScore;
    private final int highScore;
    private final List<String> supplements;
}
