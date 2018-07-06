package com.application.entrypoints.rest.core.sheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
class GetSheetDto {
    @NotNull
    @NotBlank
    private final String pollCode;

    @NotNull
    @NotBlank
    private final Long version;

    @NotNull
    @NotBlank
    private final List<String> answers;
}
