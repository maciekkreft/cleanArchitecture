package com.application.core.poll;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PollUseCase {
    private final PollDataGateway pollDataGateway;

    public List<Poll> listAllPolls() {
        return pollDataGateway.getAllBooks();
    }

    public Poll addPoll(Poll poll) {
        return pollDataGateway.addPoll(poll);
    }

    public Category addCategory(Category category) {
        return pollDataGateway.addCategory(category);
    }
}
