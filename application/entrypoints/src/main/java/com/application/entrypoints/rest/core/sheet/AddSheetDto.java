package com.application.entrypoints.rest.core.sheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
class AddSheetDto {
    @NotNull
    @NotBlank
    private final String pollCode;

    @NotNull
    @NotEmpty
    private final List<Boolean> answers;
}
