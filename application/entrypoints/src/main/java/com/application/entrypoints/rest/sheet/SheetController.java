package com.application.entrypoints.rest.sheet;

import com.application.core.poll.CategoryNotFoundException;
import com.application.core.sheet.PollNotFoundException;
import com.application.core.sheet.SheetAlreadyExists;
import com.application.core.sheet.SheetEntity;
import com.application.core.sheet.SheetUseCase;
import com.application.entrypoints.rest.exceptions.ConflictException;
import com.application.entrypoints.rest.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/sheets")
public class SheetController {
    private final SheetUseCase sheetUseCase;

    @GetMapping
    public List<GetSheetDto> listAllSheets(@RequestParam String pollCode,
                                           @RequestParam String userEmail
    ) {
        return toDto(sheetUseCase.listSheetsByPollAndUser(pollCode, userEmail));
    }

    @PostMapping
    public GetSheetDto addSheet(@RequestBody @Valid AddSheetDto dto) {
        try {
            return toDto(sheetUseCase.addSheet(toEntity(dto)));
        } catch (SheetAlreadyExists e) {
            throw new ConflictException(e);
        } catch (CategoryNotFoundException | PollNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    private GetSheetDto toDto(SheetEntity sheet) {
        return new GetSheetDto(
                sheet.getId(),
                sheet.getUserEmail(),
                sheet.getPollCode(),
                sheet.getVersion(),
                sheet.getAnswers()
        );
    }

    private List<GetSheetDto> toDto(List<SheetEntity> sheets) {
        return sheets.stream()
                .map(sheet -> toDto(sheet))
                .collect(Collectors.toList());
    }

    private SheetEntity toEntity(AddSheetDto dto) {
        return new SheetEntity(
                null,
                dto.getPollCode(),
                dto.getUserEmail(),
                dto.getVersion(),
                dto.getAnswers()
        );
    }

}

