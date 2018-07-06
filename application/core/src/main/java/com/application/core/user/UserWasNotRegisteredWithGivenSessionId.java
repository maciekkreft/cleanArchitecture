package com.application.core.user;

import com.application.core.ValidationException;

public class UserWasNotRegisteredWithGivenSessionId extends ValidationException {
    public UserWasNotRegisteredWithGivenSessionId(Long userId, String sessionId) {
        super(String.format(
                "User %d was not registered with session %s", userId, sessionId
        ));
    }
}
