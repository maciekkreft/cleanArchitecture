package com.application.core.user;

public interface UserDataGateway {
    boolean exists(Long id);
    boolean existsByUserAndSession(Long userId, String sessionId);
    UserEntity addUser(UserEntity user);
    UserEntity findById(Long userId);
}
