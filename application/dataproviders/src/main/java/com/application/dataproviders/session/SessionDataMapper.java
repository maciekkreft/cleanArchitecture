package com.application.dataproviders.session;

import com.application.core.session.SessionDataGateway;
import com.fasterxml.uuid.NoArgGenerator;
import com.fasterxml.uuid.impl.RandomBasedGenerator;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class SessionDataMapper implements SessionDataGateway {

    private final SessionRepository sessionRepository;
    private final NoArgGenerator uuidGenerator = new RandomBasedGenerator(new Random());

    @Override
    public String createSession() {
        String uuid = uuidGenerator.generate().toString();
        Session session = new Session(uuid);
        return sessionRepository.save(session).getId();
    }

    @Override
    public boolean exists(String id) {
        return sessionRepository.existsById(id);
    }

    @Override
    public String findById(String id) {
        return sessionRepository.findById(id).get().getId();
    }
}
