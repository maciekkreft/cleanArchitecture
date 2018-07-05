package com.application.entrypoints.rest.core.user;

import com.application.core.session.SessionNotFoundException;
import com.application.core.sheet.UserNotFoundException;
import com.application.core.user.UserEntity;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.configuration.Constants;
import com.application.entrypoints.rest.exceptions.ConflictException;
import com.application.entrypoints.rest.exceptions.NotFoundException;
import com.application.entrypoints.rest.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static com.application.entrypoints.rest.configuration.Constants.Cookie.SESSION;
import static com.application.entrypoints.rest.configuration.Constants.Cookie.USER;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserUseCase userUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetUserDto registerUser(
            HttpServletResponse response,
            @CookieValue(SESSION) String sessionId,
            @CookieValue(value = USER, required = false) Long userCreated
    ) {
        if (userCreated != null) {
            throw new ConflictException("User #%d already created", userCreated);
        }
        try {
            GetUserDto dto = toDto(userUseCase.createUser(sessionId));
            Cookie cookie = new Cookie(USER, dto.getId());
            response.addCookie(cookie);
            return dto;
        } catch (SessionNotFoundException e) {
            throw new NotFoundException(e);
        }
    }

    @GetMapping
    public GetUserDto authenticateAndGetUser(
            @CookieValue(USER) Long userId,
            @CookieValue(SESSION) String sessionId
    ) {
        try {
            return toDto(userUseCase.authenticateAndGetUser(userId, sessionId));
        } catch (UserNotFoundException e) {
            throw new NotFoundException(e);
        } catch (SessionNotFoundException e) {
            throw new UnauthorizedException(e);
        }
    }

    private GetUserDto toDto(UserEntity user) {
        return new GetUserDto(String.valueOf(user.getId()));
    }

}

