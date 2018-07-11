package com.application.core.session;

import com.application.common.ValidationException;

public class SessionNotFoundException extends ValidationException {
    public SessionNotFoundException(String sessionId) {
        super(String.format("Session %s does not exists", sessionId));
    }
}
