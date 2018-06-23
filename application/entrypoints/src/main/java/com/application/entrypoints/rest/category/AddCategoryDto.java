package com.application.entrypoints.rest.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
class AddCategoryDto {
    @NotNull
    @NotBlank
    private final String code;

    @NotNull
    @NotBlank
    private final String name;
}
