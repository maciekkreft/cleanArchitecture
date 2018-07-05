package com.application.dataproviders.sheet;

import com.application.dataproviders.poll.Poll;
import com.application.dataproviders.poll.PollRepository;
import com.application.dataproviders.user.User;
import com.application.dataproviders.user.UserRepository;
import com.application.core.sheet.SheetDataGateway;
import com.application.core.sheet.SheetEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class SheetDataMapper implements SheetDataGateway {

    private final SheetRepository sheetRepository;
    private final PollRepository pollRepository;
    private final UserRepository userRepository;

    @Override
    public SheetEntity addSheet(SheetEntity sheet) {
        return toEntity(sheetRepository.save(toRow(sheet)));
    }

    @Override
    public List<SheetEntity> findAllByPollCodeAndUserId(String pollCode, Long userId) {
        return toEntity(sheetRepository.findAllByPollCodeAndUserId(pollCode, userId));
    }

    public List<SheetEntity> toEntity(List<Sheet> sheets) {
        return sheets.stream()
                .map(s -> toEntity(s))
                .collect(Collectors.toList());
    }

    private SheetEntity toEntity(Sheet sheet) {
        List<String> answers = sheet.getAnswers().stream()
                .map(a -> a.getValue() ? "y" : "n")
                .collect(Collectors.toList());
        return new SheetEntity(
                sheet.getId(),
                sheet.getPoll().getCode(),
                sheet.getUser().getId(),
                sheet.getVersion(),
                answers
        );
    }

    private Sheet toRow(SheetEntity sheet) {
        Poll poll = pollRepository.findByCode(sheet.getPollCode());
        User user = userRepository.findById(sheet.getUserId()).get();
        List<Answer> answers = sheet.getAnswers().stream()
                .map(s -> new Answer(s.equals("y")))
                .collect(Collectors.toList());
        return new Sheet(poll, user, sheet.getVersion(), answers);
    }

    @Override
    public boolean exists(SheetEntity sheet) {
        return sheetRepository.existsByPollCodeAndUserIdAndVersion(
                sheet.getPollCode(),
                sheet.getUserId(),
                sheet.getVersion()
        );
    }
}
