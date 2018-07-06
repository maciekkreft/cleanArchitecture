package com.application.initialization.core.user;

import com.application.dataproviders.session.Session;
import com.application.dataproviders.session.SessionRepository;
import com.application.initialization.core.Initializer;
import lombok.Data;

@Data
public class UserInitializer implements Initializer {
    private final UserWithCustomIdRepository userInitializerRepository;
    private final SessionRepository sessionRepository;

    @Override
    public void initialize() {
        long userId = -1000L;
        String sessionId = "MOCK_SESSION_ID";
        sessionRepository.save(new Session(sessionId));
        userInitializerRepository.save(new UserWithCustomId(userId, sessionId));
    }
}
