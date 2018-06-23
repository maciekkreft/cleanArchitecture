package com.application.core.poll;

public class PollAlreadyExists extends RuntimeException {
    public PollAlreadyExists(String pollCode) {
        super(String.format("Poll %s already exists", pollCode));
    }
}
