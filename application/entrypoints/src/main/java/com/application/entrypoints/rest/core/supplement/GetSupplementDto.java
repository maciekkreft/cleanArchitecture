package com.application.entrypoints.rest.core.supplement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class GetSupplementDto {
    private final String code;
    private final String name;
}
