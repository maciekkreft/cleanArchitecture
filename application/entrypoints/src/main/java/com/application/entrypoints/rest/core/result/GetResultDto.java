package com.application.entrypoints.rest.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class GetResultDto {
    private final long version;
    private final String pollCode;
    private final String deficiency;
    private final String createdAt;
}
