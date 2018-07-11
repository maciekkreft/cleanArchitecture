package com.application.core.result;

import com.application.core.poll.PollDataGateway;
import com.application.core.poll.PollEntity;
import com.application.core.sheet.SheetDataGateway;
import com.application.core.sheet.SheetEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ResultUseCase {
    private final SheetDataGateway sheetDataGateway;
    private final PollDataGateway pollDataGateway;

    public ResultEntity getLastVersion(String pollCode, Long userId) {
        long maxVersion = sheetDataGateway.findLastVersion(pollCode, userId).getVersion();
        return getVersion(maxVersion, pollCode, userId);
    }

    public ResultEntity getVersion(Long sheetVersion, String pollCode, Long userId) {
        PollEntity poll = pollDataGateway.getPollByCode(pollCode);
        SheetEntity sheet = sheetDataGateway.findOneVersion(sheetVersion, pollCode, userId);

        return toEntity(poll, sheet);
    }

    public List<ResultEntity> getAll(Long userId) {
        Map<String, PollEntity> pollByCode = pollDataGateway.getAllPolls().stream()
                .collect(Collectors.toMap(p -> p.getCode(), p -> p));
        List<SheetEntity> sheets = sheetDataGateway.findAll(userId);

        return sheets.stream()
                .map(s -> toEntity(pollByCode.get(s.getPollCode()), s))
                .collect(Collectors.toList());
    }

    private ResultEntity toEntity(PollEntity poll, SheetEntity sheet) {
        long m = poll.getMediumScore();
        long h = poll.getHighScore();
        long s = sheet.getAnswers().stream().filter(a -> a.equals(true)).count();

        ResultEntity.Result result = ResultEntity.Result.LOW_RISK;
        if (s >= m) result = ResultEntity.Result.MEDIUM_RISK;
        if (s >= h) result = ResultEntity.Result.HIGH_RISK;

        return new ResultEntity(
                sheet.getVersion(),
                poll.getCode(),
                result
        );
    }
}
