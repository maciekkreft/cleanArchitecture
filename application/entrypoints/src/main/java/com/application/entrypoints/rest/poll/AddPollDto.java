package com.application.entrypoints.rest.poll;

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
public class AddPollDto {
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
}
