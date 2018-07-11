package com.application.entrypoints.rest.interceptors;

import com.application.common.ValidationException;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.application.entrypoints.rest.configuration.Constants.Cookies.SESSION_ID;
import static com.application.entrypoints.rest.configuration.Constants.Cookies.USER_ID;
import static com.application.entrypoints.rest.interceptors.CookieHelper.findCookie;

@AllArgsConstructor
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private final UserUseCase userUseCase;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object h) {
        Long userId = Long.valueOf(findCookie(req, USER_ID).get().getValue());
        String sessionId = findCookie(req, SESSION_ID).get().getValue();

        try {
            userUseCase.authenticate(userId, sessionId);
            req.setAttribute(USER_ID, userId);
        } catch (ValidationException e) {
            throw new UnauthorizedException(e);
        }

        return true;
    }

}
