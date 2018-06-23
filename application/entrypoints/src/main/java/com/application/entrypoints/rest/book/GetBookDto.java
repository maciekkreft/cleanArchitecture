package com.application.entrypoints.rest.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Valid
public class GetBookDto {
    @NotNull
    @NotBlank
    private Long id;

    @NotNull
    @NotBlank
    private final String title;
}
