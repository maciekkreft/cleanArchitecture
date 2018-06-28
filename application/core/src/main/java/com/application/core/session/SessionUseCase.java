package com.application.core.session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SessionUseCase {
    private final SessionDataGateway sessionDataGateway;

    public String createSession() {
        return sessionDataGateway.createSession();
    }

    public void verifySession(String id) {
        if (!sessionDataGateway.exists(id)) {
            throw new SessionNotFoundException(id);
        }
    }

    public String getSession(String id) {
        verifySession(id);
        return sessionDataGateway.findById(id);
    }

}
