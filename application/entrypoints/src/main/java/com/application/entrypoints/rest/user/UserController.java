package com.application.entrypoints.rest.user;

import com.application.core.user.RepeatedPasswordNotMatches;
import com.application.core.user.UserAlreadyExists;
import com.application.core.user.UserEntity;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.exceptions.BadRequestException;
import com.application.entrypoints.rest.exceptions.ConflictException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserUseCase userUseCase;

    @PostMapping
    public GetUserDto addUser(@RequestBody @Valid AddUserDto dto) {
        try {
            return toDto(userUseCase.addUser(toEntity(dto)));
        } catch (UserAlreadyExists e) {
            throw new ConflictException(e);
        } catch (RepeatedPasswordNotMatches e) {
            throw new BadRequestException(e);
        }
    }

    private GetUserDto toDto(UserEntity user) {
        return new GetUserDto(user.getId(), user.getEmail());
    }

    private UserEntity toEntity(AddUserDto dto) {
        return new UserEntity(
                null,
                dto.getEmail(),
                dto.getPassword(),
                dto.getPasswordRepeated()
        );
    }

}

