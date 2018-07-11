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
    public SheetEntity addVersion(SheetEntity sheet) {
        return toEntity(sheetRepository.save(toRow(sheet)));
    }

    @Override
    public List<SheetEntity> findAllVersions(String pollCode, Long userId) {
        return toEntity(sheetRepository.findAllByPollCodeAndUserId(pollCode, userId));
    }

    @Override
    public SheetEntity findOneVersion(Long version, String pollCode, Long userId) {
        return toEntity(sheetRepository.findOneByVersionAndPollCodeAndUserId(version, pollCode, userId));
    }

    @Override
    public SheetEntity findLastVersion(String pollCode, Long userId) {
        return toEntity(sheetRepository.findTopByPollCodeAndUserIdOrderByVersionDesc(pollCode, userId));
    }

    public List<SheetEntity> toEntity(List<Sheet> sheets) {
        return sheets.stream()
                .map(s -> toEntity(s))
                .collect(Collectors.toList());
    }

    private SheetEntity toEntity(Sheet sheet) {
        List<Boolean> answers = sheet.getAnswers().stream()
                .map(a -> a.getValue())
                .collect(Collectors.toList());
        return new SheetEntity(
                sheet.getVersion(),
                sheet.getUser().getId(),
                sheet.getPoll().getCode(),
                answers
        );
    }

    private Sheet toRow(SheetEntity sheet) {
        Poll poll = pollRepository.findByCode(sheet.getPollCode());
        User user = userRepository.findById(sheet.getUserId()).get();
        long version = nextVersion(sheet);
        List<Answer> answers = sheet.getAnswers().stream()
                .map(s -> new Answer(s))
                .collect(Collectors.toList());
        return new Sheet(poll, user, version, answers);
    }

    private long nextVersion(SheetEntity sheet) {
        Sheet sheetWithMaxVersion = sheetRepository.findTopByPollCodeAndUserIdOrderByVersionDesc(
                sheet.getPollCode(), sheet.getUserId()
        );
        long maxVersion = sheetWithMaxVersion != null ? sheetWithMaxVersion.getVersion() : -1L;
        return maxVersion + 1L;
    }

}
