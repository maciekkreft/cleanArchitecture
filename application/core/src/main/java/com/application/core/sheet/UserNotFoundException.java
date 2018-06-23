package com.application.core.sheet;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(SheetEntity sheet) {
        super(String.format("User with email %s does not exists", sheet.getUserEmail()));
    }
}
