package com.application.entrypoints.rest.session;

import com.application.core.session.SessionNotFoundException;
import com.application.core.session.SessionUseCase;
import com.application.core.user.UserWasNotRegisteredWithGivenSessionId;
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
@RequestMapping("/sessions")
public class SessionController {

    private SessionUseCase sessionUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GetSessionDto createSession(
            HttpServletResponse response,
            @CookieValue(value = "session", required = false) String sessionCreated
    ) {
        if (sessionCreated != null) {
            throw new ConflictException("Session already created");
        }
        String id = sessionUseCase.createSession();
        Cookie cookie = new Cookie("session", id);
        response.addCookie(cookie);
        return toDto(id);
    }

    @GetMapping
    public GetSessionDto verifyAndGetSession(@CookieValue("session") String id) {
        try {
            return toDto(sessionUseCase.getSession(id));
        } catch (SessionNotFoundException e) {
            throw new NotFoundException(e);
        } catch (UserWasNotRegisteredWithGivenSessionId e) {
            throw new UnauthorizedException(e);
        }
    }

    public GetSessionDto toDto(String sessionId) {
        return new GetSessionDto(sessionId);
    }

}
