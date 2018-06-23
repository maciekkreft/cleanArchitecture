package com.application.entrypoints.rest.poll;

import lombok.Data;

import java.util.List;

@Data
class GetPollDto {
    private final Long id;
    private final String code;
    private final String name;
    private final String categoryCode;
    private final List<String> questions;
}
