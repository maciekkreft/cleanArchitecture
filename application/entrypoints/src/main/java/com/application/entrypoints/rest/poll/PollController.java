package com.application.entrypoints.rest.poll;

import com.application.core.poll.CategoryNotFoundException;
import com.application.core.poll.PollAlreadyExists;
import com.application.core.poll.PollEntity;
import com.application.core.poll.PollUseCase;
import com.application.entrypoints.rest.exceptions.ConflictException;
import com.application.entrypoints.rest.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public GetPollDto addPoll(@RequestBody @Valid AddPollDto dto) {
        try {
            return toDto(pollUseCase.addPoll(toEntity(dto)));
        } catch (PollAlreadyExists e) {
            throw new ConflictException(e);
        } catch (CategoryNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    private GetPollDto toDto(PollEntity poll) {
        return new GetPollDto(
                poll.getId(),
                poll.getCode(),
                poll.getName(),
                poll.getCategoryCode(),
                poll.getQuestions()
        );
    }

    private List<GetPollDto> toDto(List<PollEntity> polls) {
        return polls.stream()
                .map(poll -> toDto(poll))
                .collect(Collectors.toList());
    }

    private PollEntity toEntity(AddPollDto dto) {
        return new PollEntity(
                null,
                dto.getCode(),
                dto.getName(),
                dto.getCategoryCode(),
                dto.getQuestions()
        );
    }

}

