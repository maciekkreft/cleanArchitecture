package com.application.entrypoints.rest.poll;

import com.application.core.poll.Poll;
import com.application.core.poll.PollUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/polls")
public class PollController {
    private final PollUseCase pollUseCase;

    @GetMapping
    public List<GetPollDto> listAllPolls() {
        return toDto(pollUseCase.listAllPolls());
    }

    @PostMapping
    public GetPollDto addPoll(@RequestBody @Valid AddPollDto dto) {
        return toDto(pollUseCase.addPoll(toEntity(dto)));
    }

    private GetPollDto toDto(Poll poll) {
        return new GetPollDto(poll.getId(), poll.getCode(), poll.getName(), poll.getCategoryCode());
    }

    private List<GetPollDto> toDto(List<Poll> polls) {
        return polls.stream()
                .map(poll -> toDto(poll))
                .collect(Collectors.toList());
    }

    private Poll toEntity(AddPollDto dto) {
        return new Poll(null, dto.getCode(), dto.getName(), dto.getCategoryCode());
    }

}

