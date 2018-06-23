package com.application.core.user;

import lombok.Data;

@Data
public class UserEntity {
    private final Long id;
    private final String email;
    private final String password;
    private final String passwordRepeated;
}
