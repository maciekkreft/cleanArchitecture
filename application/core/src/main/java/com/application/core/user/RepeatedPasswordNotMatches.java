package com.application.core.user;

public class RepeatedPasswordNotMatches extends RuntimeException {
    public RepeatedPasswordNotMatches(String email) {
        super(String.format("Two passwords for user %s not matches", email));
    }
}
