package com.application.entrypoints.rest.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
class AddUserDto {
    @NotNull
    @NotBlank
    private final String email;

    @NotNull
    @NotBlank
    private final String password;

    @NotNull
    @NotBlank
    private final String passwordRepeated;
}
