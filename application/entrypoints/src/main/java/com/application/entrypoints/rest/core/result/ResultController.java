package com.application.entrypoints.rest.core.result;

import com.application.core.result.ResultEntity;
import com.application.core.result.ResultUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultUseCase resultUseCase;

    @GetMapping
    public List<GetResultDto> getAllResultsForUser(
            @RequestAttribute Long userId
    ) {
        return toDto(resultUseCase.getAll(userId));
    }

    @GetMapping
    @RequestMapping("/{pollCode}/latest")
    public GetResultDto getLatestVersion(
            @PathVariable String pollCode,
            @RequestAttribute Long userId
    ) {
        return toDto(resultUseCase.getLastVersion(pollCode, userId));
    }

    @GetMapping
    @RequestMapping("/{pollCode}/{sheetVersion}")
    public GetResultDto getGivenVersion(
            @PathVariable String pollCode,
            @PathVariable Long sheetVersion,
            @RequestAttribute Long userId
    ) {
        return toDto(resultUseCase.getVersion(sheetVersion, pollCode, userId));
    }

    private GetResultDto toDto(ResultEntity r) {
        return new GetResultDto(
                r.getVersion(),
                r.getPollCode(),
                r.getResult().name()
        );
    }

    private List<GetResultDto> toDto(List<ResultEntity> results) {
        return results.stream()
                .map(r -> toDto(r))
                .collect(Collectors.toList());
    }

}
