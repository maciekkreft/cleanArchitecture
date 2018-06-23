package com.application.entrypoints.rest.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class GetCategoryDto {
    @NotNull
    @NotBlank
    private final Long id;

    @NotNull
    @NotBlank
    private final String code;

    @NotNull
    @NotBlank
    private final String name;
}
