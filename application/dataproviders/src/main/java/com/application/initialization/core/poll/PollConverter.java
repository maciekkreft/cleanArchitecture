package com.application.initialization.core.poll;

import com.application.dataproviders.category.Category;
import com.application.dataproviders.poll.Poll;
import com.application.dataproviders.poll.Question;
import com.application.dataproviders.poll.Score;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PollConverter {

    @NonNull
    public static List<Poll> toRows(PollsJson jsonAsObject, Map<String, Category> categoryByCode) {
        return jsonAsObject.getPolls().stream()
                .map((PollsJson.PollJson p) -> new Poll(
                        p.getCode(),
                        p.getName(),
                        categoryByCode.get(p.getCategory()),
                        p.getQuestions().stream()
                                .map((String q) -> new Question(q))
                                .collect(Collectors.toList()),
                        new Score(
                                p.getScores().getMedium(),
                                p.getScores().getHigh()
                        )

                ))
                .collect(Collectors.toList());
    }
}
