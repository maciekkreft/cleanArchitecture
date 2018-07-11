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

    public List<SheetEntity> listSheetsByPollAndUser(String pollCode, Long userId) {
        return sheetDataGateway.findAllVersions(pollCode, userId);
    }

    public SheetEntity addSheet(SheetEntity sheet) {
        if (!pollDataGateway.exists(sheet.getPollCode())) {
            throw new PollNotFoundException(sheet);
        }
        if (!userDataGateway.exists(sheet.getUserId())) {
            throw new UserNotFoundException(sheet);
        }
        int a = sheet.getAnswers().size();
        int q = pollDataGateway.getPollByCode(sheet.getPollCode()).getQuestions().size();
        if(a != q) {
            throw new MissingAnswersInSheet(sheet, a, q);
        }
        return sheetDataGateway.addVersion(sheet);
    }

}
