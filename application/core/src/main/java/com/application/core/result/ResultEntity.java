package com.application.core.result;

import lombok.Data;

import java.util.Date;

@Data
public class ResultEntity {
    private final long version;
    private final String pollCode;
    private final Deficiency deficiency;
    private final Date createdAt;

    public enum Deficiency {
       LOW, MEDIUM, HIGH
    }
}
