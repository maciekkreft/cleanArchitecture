package com.application.core.sheet;

import com.application.core.ValidationException;

public class SheetAlreadyExists extends ValidationException {
    public SheetAlreadyExists(SheetEntity sheet) {
        super(String.format(
                "Sheet for user %s and poll %s with %d version already exists",
                sheet.getUserId(), sheet.getPollCode(), sheet.getVersion())
        );
    }
}
