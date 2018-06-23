package com.application.core.dataproviders.poll;

import com.application.core.poll.Category;
import com.application.core.poll.Poll;
import com.application.core.poll.PollDataGateway;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class PollDataMapper implements PollDataGateway {

    private final PollRepository pollRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<Poll> getAllBooks() {
        return toEntity(pollRepository.findAll());
    }

    @Override
    public Poll addPoll(Poll poll) {
        return toEntity(pollRepository.save(toRow(poll)));
    }

    @Override
    public Category addCategory(Category category) {
        return toEntity(categoryRepository.save(toRow(category)));
    }

    private Poll toEntity(PollRow r) {
        return new Poll(r.getId(), r.getCode(), r.getName(), r.getCategory().getCode());
    }

    private Category toEntity(CategoryRow r) {
        return new Category(r.getId(), r.getCode(), r.getName());
    }

    private List<Poll> toEntity(Iterable<PollRow> pollRows) {
        return StreamSupport.stream(pollRows.spliterator(), false)
                .map(r -> toEntity(r))
                .collect(Collectors.toList());
    }

    private PollRow toRow(Poll poll) {
        CategoryRow categoryRow = categoryRepository.findByCode(poll.getCategoryCode());
        return new PollRow(poll.getCode(), poll.getName(), categoryRow);
    }

    private CategoryRow toRow(Category category) {
        return new CategoryRow(category.getCode(), category.getName());
    }
}
