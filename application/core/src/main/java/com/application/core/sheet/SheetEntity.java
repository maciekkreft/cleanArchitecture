package com.application.core.sheet;

import lombok.Data;

import java.util.List;

@Data
public class SheetEntity {
    private final Long id;
    private final String pollCode;
    private final String userEmail;
    private final Long version;
    private final List<String> answers;
}
