package com.application.core.sheet;

import lombok.Data;

import java.util.List;

@Data
public class SheetEntity {
    private final Long version;
    private final Long userId;
    private final String pollCode;
    private final List<Boolean> answers;
}
