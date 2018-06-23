package com.application.core.poll;

import lombok.Data;

@Data
public class Poll {
    private final Long id;
    private final String code;
    private final String name;
    private final String categoryCode;
}
