package com.application.core.sheet;

public class PollNotFoundException extends RuntimeException {
    public PollNotFoundException(SheetEntity sheet) {
        super(String.format("Poll %s does not exists", sheet.getPollCode()));
    }
}
