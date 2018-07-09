package com.application.core.poll;

import com.application.core.category.CategoryDataGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PollUseCase {
    private final PollDataGateway pollDataGateway;
    private final CategoryDataGateway categoryDataGateway;

    public List<PollEntity> listAllPolls() {
        return pollDataGateway.getAllPolls();
    }

    public PollEntity addPoll(PollEntity poll) {
        if (!categoryDataGateway.exists(poll.getCategoryCode())) {
            throw new CategoryNotFoundException(poll.getCategoryCode());
        }
        if (pollDataGateway.exists(poll.getCode())) {
            throw new PollAlreadyExists(poll.getCode());
        }
        return pollDataGateway.addPoll(poll);
    }

}
