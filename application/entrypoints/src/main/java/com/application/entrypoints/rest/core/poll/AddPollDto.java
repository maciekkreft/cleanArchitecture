package com.application.entrypoints.rest.core.poll;

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
class AddPollDto {
    @NotNull
    @NotBlank
    private final String code;

    @NotNull
    @NotBlank
    private final String name;

    @NotNull
    @NotBlank
    private final String categoryCode;

    @NotNull
    @NotEmpty
    private final List<String> questions;

    @NotNull
    @NotBlank
    private final int mediumScore;

    @NotNull
    @NotBlank
    private final int highScore;

    @NotNull
    @NotEmpty
    private final List<String> supplements;
}
