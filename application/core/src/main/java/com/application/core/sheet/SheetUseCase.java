package com.application.core.sheet;

import com.application.core.poll.PollDataGateway;
import com.application.core.user.UserDataGateway;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SheetUseCase {
    private final SheetDataGateway sheetDataGateway;
    private final PollDataGateway pollDataGateway;
    private final UserDataGateway userDataGateway;

    public List<SheetEntity> listSheetsByPollAndUser(String pollCode, String userEmail) {
        return sheetDataGateway.findAllByPollCodeAndUserEmail(pollCode, userEmail);
    }

    public SheetEntity addSheet(SheetEntity sheet) {
        if (!pollDataGateway.exists(sheet.getPollCode())) {
            throw new PollNotFoundException(sheet);
        }
        if (!userDataGateway.exists(sheet.getUserEmail())) {
            throw new UserNotFoundException(sheet);
        }
        if (sheetDataGateway.exists(sheet)) {
            throw new SheetAlreadyExists(sheet);
        }
        return sheetDataGateway.addSheet(sheet);
    }

}
