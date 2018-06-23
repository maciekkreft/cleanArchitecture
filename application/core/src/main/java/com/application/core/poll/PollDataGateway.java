package com.application.core.poll;

import java.util.List;

public interface PollDataGateway {
    List<Poll> getAllBooks();
    Poll addPoll(Poll poll);
    Category addCategory(Category category);
}
