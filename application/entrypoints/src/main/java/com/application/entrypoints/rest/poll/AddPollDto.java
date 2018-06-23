package com.application.entrypoints.rest.poll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
}
