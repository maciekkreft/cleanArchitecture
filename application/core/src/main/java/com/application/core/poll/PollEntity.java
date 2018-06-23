package com.application.core.poll;

import lombok.Data;

import java.util.List;

@Data
public class PollEntity {
    private final Long id;
    private final String code;
    private final String name;
    private final String categoryCode;
    private final List<String> questions;
}
