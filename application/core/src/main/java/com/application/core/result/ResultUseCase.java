package com.application.core.result;

import com.application.core.poll.PollDataGateway;
import com.application.core.poll.PollEntity;
import com.application.core.sheet.SheetDataGateway;
import com.application.core.sheet.SheetEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResultUseCase {
    private final SheetDataGateway sheetDataGateway;
    private final PollDataGateway pollDataGateway;

    public ResultEntity getVersion(Long sheetVersion, String pollCode, Long userId) {
        PollEntity poll = pollDataGateway.getPollByCode(pollCode);
        SheetEntity sheet = sheetDataGateway.findOneVersion(sheetVersion, pollCode, userId);

        long m = poll.getMediumScore();
        long h = poll.getHighScore();
        long s = sheet.getAnswers().stream().filter(a -> a.equals(true)).count();

        ResultEntity.Result result = ResultEntity.Result.LOW_RISK;
        if (s >= m) result = ResultEntity.Result.MEDIUM_RISK;
        if (s >= h) result = ResultEntity.Result.HIGH_RISK;

        return new ResultEntity(
                sheet.getVersion(),
                pollCode,
                result
        );
    }

    public ResultEntity getLastVersion(String pollCode, Long userId) {
        long maxVersion = sheetDataGateway.findLastVersion(pollCode, userId).getVersion();
        return getVersion(maxVersion, pollCode, userId);
    }
}
