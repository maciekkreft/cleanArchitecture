package com.application.core.user;

public interface UserDataGateway {
    boolean exists(Long id);
    boolean existsByUserAndSession(Long userId, String sessionId);
    UserEntity createUser(String sessionId);
    UserEntity findById(Long userId);
}
