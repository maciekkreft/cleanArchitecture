package com.application.core.dataproviders.user;

import com.application.core.user.UserDataGateway;
import com.application.core.user.UserEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDataMapper implements UserDataGateway {

    private final UserRepository userRepository;

    @Override
    public UserEntity addUser(UserEntity user) {
        return toEntity(userRepository.save(toRow(user)));
    }

    @Override
    public UserEntity findById(Long userId) {
        return toEntity(userRepository.findById(userId).get());
    }

    @Override
    public boolean exists(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public boolean existsByUserAndSession(Long id, String sessionId) {
        return userRepository.existsByIdAndSessionId(id, sessionId);
    }

    private UserEntity toEntity(User u) {
        return new UserEntity(u.getId(), u.getSessionId());
    }

    private User toRow(UserEntity user) {
        return new User(user.getSessionId());
    }
}
