package com.application.core.supplement;

import lombok.Data;

@Data
public class SupplementEntity {
    private final String code;
    private final String name;
    private final String dose;
    private final String dosing;
}
