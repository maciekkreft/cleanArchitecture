package com.application.initialization.core.supplement;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SupplementsJson {
    private final List<SupplementJson> supplements = new ArrayList<>();

    @Data
    public static class SupplementJson {
        private final String code;
        private final String name;
    }
}
