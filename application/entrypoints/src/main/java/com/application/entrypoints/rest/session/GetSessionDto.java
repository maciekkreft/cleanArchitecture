package com.application.entrypoints.rest.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
class GetSessionDto {
    @NotNull
    @NotBlank
    private final String id;
}
