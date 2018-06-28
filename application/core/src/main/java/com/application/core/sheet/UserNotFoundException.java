package com.application.core.sheet;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long userId) {
        super(String.format("User #%d does not exists", userId));
    }

    public UserNotFoundException(SheetEntity sheet) {
        this(sheet.getUserId());
    }

}
