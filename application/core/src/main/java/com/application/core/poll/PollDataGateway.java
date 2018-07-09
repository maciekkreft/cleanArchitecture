package com.application.core.poll;

import java.util.List;

public interface PollDataGateway {
    List<PollEntity> getAllPolls();
    PollEntity addPoll(PollEntity poll);
    boolean exists(String pollCode);
    PollEntity getPollByCode(String pollCode);
}
