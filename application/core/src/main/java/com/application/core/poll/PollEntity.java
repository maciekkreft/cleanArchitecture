package com.application.core.poll;

import com.application.core.category.CategoryEntity;
import lombok.Data;

import java.util.List;

@Data
public class PollEntity {
    private final String code;
    private final String name;
    private final CategoryEntity category;
    private final List<String> questions;
    private final int mediumScore;
    private final int highScore;

    public String getCategoryCode() {
        return getCategory().getCode();
    }
}
