package com.application.core.user;

public class UserWasNotRegisteredWithGivenSessionId extends RuntimeException {
    public UserWasNotRegisteredWithGivenSessionId(Long userId, String sessionId) {
        super(String.format(
                "User %d was not registered with session %s", userId, sessionId
        ));
    }
}
