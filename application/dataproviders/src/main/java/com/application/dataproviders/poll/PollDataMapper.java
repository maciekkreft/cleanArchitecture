package com.application.dataproviders.poll;

import com.application.core.category.CategoryEntity;
import com.application.dataproviders.category.Category;
import com.application.dataproviders.category.CategoryRepository;
import com.application.core.poll.PollDataGateway;
import com.application.core.poll.PollEntity;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class PollDataMapper implements PollDataGateway {

    private final PollRepository pollRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<PollEntity> getAllBooks() {
        return toEntity(pollRepository.findAll());
    }

    @Override
    public PollEntity addPoll(PollEntity poll) {
        return toEntity(pollRepository.save(toRow(poll)));
    }

    @Override
    public boolean exists(String pollCode) {
        return pollRepository.existsByCode(pollCode);
    }

    private PollEntity toEntity(Poll p) {
        List<String> questions = p.getQuestions().stream()
                .map(q -> q.getContent())
                .collect(Collectors.toList());
        return new PollEntity(
                p.getCode(),
                p.getName(),
                toEntity(p.getCategory()),
                questions,
                Integer.valueOf(p.getScores().getMedium()),
                Integer.valueOf(p.getScores().getHigh()));
    }

    private CategoryEntity toEntity(Category c) {
       return new CategoryEntity(c.getCode(), c.getName());
    }

    private List<PollEntity> toEntity(Iterable<Poll> pollRows) {
        return StreamSupport.stream(pollRows.spliterator(), false)
                .map(r -> toEntity(r))
                .collect(Collectors.toList());
    }

    private Poll toRow(PollEntity poll) {
        Category categoryRow = categoryRepository.findByCode(poll.getCategoryCode());
        List<Question> questions = poll.getQuestions().stream()
                .map(s -> new Question(s))
                .collect(Collectors.toList());
        return new Poll(
                poll.getCode(),
                poll.getName(),
                categoryRow,
                questions,
                new Score(poll.getMediumScore(), poll.getHighScore()));
    }

}