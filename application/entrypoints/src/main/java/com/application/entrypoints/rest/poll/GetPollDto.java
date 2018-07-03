package com.application.entrypoints.rest.poll;

import com.application.entrypoints.rest.category.GetCategoryDto;
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
}
