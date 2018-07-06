package com.application.core.poll;

import com.application.core.ValidationException;

public class PollAlreadyExists extends ValidationException {
    public PollAlreadyExists(String pollCode) {
        super(String.format("Poll %s already exists", pollCode));
    }
}
