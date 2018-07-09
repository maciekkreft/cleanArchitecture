package com.application.entrypoints.rest.core.sheet;

import com.application.core.poll.CategoryNotFoundException;
import com.application.core.sheet.MissingAnswersInSheet;
import com.application.core.sheet.PollNotFoundException;
import com.application.core.sheet.SheetEntity;
import com.application.core.sheet.SheetUseCase;
import com.application.entrypoints.rest.exceptions.BadRequestException;
import com.application.entrypoints.rest.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/sheets")
public class SheetController {
    private final SheetUseCase sheetUseCase;

    @GetMapping("/{pollCode}")
    public List<GetSheetDto> listAllSheets(@PathVariable String pollCode,
                                           @RequestAttribute Long userId
    ) {
        return toDto(sheetUseCase.listSheetsByPollAndUser(pollCode, userId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetSheetDto addSheet(@RequestBody @Valid AddSheetDto dto,
                                @RequestAttribute Long userId
    ) {
        try {
            return toDto(sheetUseCase.addSheet(toEntity(dto, userId)));
        } catch (CategoryNotFoundException | PollNotFoundException e) {
            throw new NotFoundException(e);
        } catch (MissingAnswersInSheet e) {
            throw new BadRequestException(e);
        }
    }

    private GetSheetDto toDto(SheetEntity sheet) {
        return new GetSheetDto(
                sheet.getVersion(),
                sheet.getPollCode(),
                sheet.getAnswers()
        );
    }

    private List<GetSheetDto> toDto(List<SheetEntity> sheets) {
        return sheets.stream()
                .map(sheet -> toDto(sheet))
                .collect(Collectors.toList());
    }

    private SheetEntity toEntity(AddSheetDto dto, Long userId) {
        return new SheetEntity(
                null,
                userId,
                dto.getPollCode(),
                dto.getAnswers()
        );
    }

}

