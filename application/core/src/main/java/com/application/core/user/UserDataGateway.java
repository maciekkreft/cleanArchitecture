package com.application.core.user;

public interface UserDataGateway {
    boolean exists(String email);

    UserEntity addUser(UserEntity user);
}
