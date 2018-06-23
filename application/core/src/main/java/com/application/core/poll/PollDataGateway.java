package com.application.core.poll;

import java.util.List;

public interface PollDataGateway {
    List<PollEntity> getAllBooks();

    PollEntity addPoll(PollEntity poll);

    boolean exists(String pollCode);
}
