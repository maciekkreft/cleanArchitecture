package com.application.core.user;

import com.application.core.session.SessionUseCase;
import com.application.core.sheet.UserNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserUseCase {
    private final UserDataGateway userDataGateway;
    private final SessionUseCase sessionUseCase;

    public UserEntity addUser(UserEntity user) {
        sessionUseCase.verifySession(user.getSessionId());
        return userDataGateway.addUser(user);
    }

    private void authenticate(Long userId, String sessionId) {
        sessionUseCase.verifySession(sessionId);
        if(!userDataGateway.exists(userId)) {
            throw new UserNotFoundException(userId);
        }
        if(!userDataGateway.existsByUserAndSession(userId, sessionId)) {
            throw new UserWasNotRegisteredWithGivenSessionId(userId, sessionId);
        }
    }

    public UserEntity getUser(Long userId, String sessionId) {
        authenticate(userId, sessionId);
        return userDataGateway.findById(userId);
    }
}
