package com.application.core.user;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String email) {
        super(String.format("User with email %s already exists", email));
    }
}
