package com.application.core.sheet;

import com.application.common.ValidationException;

public class MissingAnswersInSheet extends ValidationException {

    public MissingAnswersInSheet(SheetEntity sheet, int a, int q) {
        super(String.format("Sheet for poll #%s, has %s of %s required questions",
                sheet.getPollCode(), a, q));
    }

}
