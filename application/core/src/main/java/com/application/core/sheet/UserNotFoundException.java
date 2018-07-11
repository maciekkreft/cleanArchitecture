package com.application.core.sheet;

import com.application.common.ValidationException;

public class UserNotFoundException extends ValidationException {
    public UserNotFoundException(Long userId) {
        super(String.format("User #%d does not exists", userId));
    }

    public UserNotFoundException(SheetEntity sheet) {
        this(sheet.getUserId());
    }

}
