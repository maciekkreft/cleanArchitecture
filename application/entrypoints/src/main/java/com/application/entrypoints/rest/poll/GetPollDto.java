package com.application.entrypoints.rest.poll;

import lombok.Data;

@Data
public class GetPollDto {
    private final Long id;
    private final String code;
    private final String name;
    private final String categoryCode;
}
