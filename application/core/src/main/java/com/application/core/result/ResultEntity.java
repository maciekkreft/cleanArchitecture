package com.application.core.result;

import lombok.Data;

@Data
public class ResultEntity {
    private final long version;
    private final String pollCode;
    private final Result result;

    public enum Result {
       LOW_RISK, MEDIUM_RISK, HIGH_RISK
    }
}
