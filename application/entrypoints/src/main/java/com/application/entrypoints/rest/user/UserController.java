package com.application.entrypoints.rest.user;

import com.application.core.session.SessionNotFoundException;
import com.application.core.sheet.UserNotFoundException;
import com.application.core.user.UserEntity;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.exceptions.ConflictException;
import com.application.entrypoints.rest.exceptions.NotFoundException;
import com.application.entrypoints.rest.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserUseCase userUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetUserDto registerUser(
            HttpServletResponse response,
            @CookieValue("session") String sessionId,
            @CookieValue(value = "user", required = false) Long userCreated
    ) {
        if (userCreated != null) {
            throw new ConflictException("User #%d already created", userCreated);
        }
        try {
            GetUserDto dto = toDto(userUseCase.addUser(toEntity(sessionId)));
            Cookie cookie = new Cookie("user", dto.getId());
            response.addCookie(cookie);
            return dto;
        } catch (SessionNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @GetMapping
    public GetUserDto authenticateAndGetUser(
            @CookieValue("user") Long userId,
            @CookieValue("session") String sessionId
    ) {
        try {
            return toDto(userUseCase.getUser(userId, sessionId));
        } catch (UserNotFoundException e) {
            throw new NotFoundException(e);
        } catch (SessionNotFoundException e) {
            throw new UnauthorizedException(e);
        }
    }

    private GetUserDto toDto(UserEntity user) {
        return new GetUserDto(String.valueOf(user.getId()));
    }

    private UserEntity toEntity(String sessionId) {
        return new UserEntity(null, sessionId);
    }

}

