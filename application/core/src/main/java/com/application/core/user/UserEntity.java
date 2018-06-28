package com.application.core.user;

import lombok.Data;

@Data
public class UserEntity {
    private final Long id;
    private final String sessionId;
}
