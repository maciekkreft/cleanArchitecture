package com.application.core.sheet;

public class SheetAlreadyExists extends RuntimeException {
    public SheetAlreadyExists(SheetEntity sheet) {
        super(String.format(
                "Sheet for user %s and poll %s with %d version already exists",
                sheet.getUserId(), sheet.getPollCode(), sheet.getVersion())
        );
    }
}
