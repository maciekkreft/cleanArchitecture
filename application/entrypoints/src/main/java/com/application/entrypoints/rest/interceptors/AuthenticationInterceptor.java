package com.application.entrypoints.rest.interceptors;

import com.application.core.ValidationException;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.application.entrypoints.rest.configuration.Constants.Cookie.SESSION;
import static com.application.entrypoints.rest.configuration.Constants.Cookie.USER;
import static com.application.entrypoints.rest.interceptors.CookieHelper.findCookie;

@AllArgsConstructor
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private final UserUseCase userUseCase;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object h) {
        Long userId = Long.valueOf(findCookie(req, USER).get().getValue());
        String sessionId = findCookie(req, SESSION).get().getValue();

        try {
            userUseCase.authenticate(userId, sessionId);
        } catch (ValidationException e) {
            throw new UnauthorizedException(e);
        }

        return true;
    }

}
