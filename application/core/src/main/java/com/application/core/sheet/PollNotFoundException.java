package com.application.core.sheet;

import com.application.common.ValidationException;

public class PollNotFoundException extends ValidationException {
    public PollNotFoundException(SheetEntity sheet) {
        super(String.format("Poll %s does not exists", sheet.getPollCode()));
    }
}
