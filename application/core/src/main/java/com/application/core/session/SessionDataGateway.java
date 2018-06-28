package com.application.core.session;

public interface SessionDataGateway {
    String createSession();
    boolean exists(String id);
    String findById(String id);
}
