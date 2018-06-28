package com.application.core.session;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException(String sessionId) {
        super(String.format("Session %s does not exists", sessionId));
    }
}
