package com.application.entrypoints.rest.interceptors;

import com.application.core.ValidationException;
import com.application.core.session.SessionUseCase;
import com.application.core.user.UserEntity;
import com.application.core.user.UserUseCase;
import com.application.entrypoints.rest.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static com.application.entrypoints.rest.configuration.Constants.Cookie.SESSION;
import static com.application.entrypoints.rest.configuration.Constants.Cookie.USER;

@AllArgsConstructor
public class CreateUserCookieInterceptor extends HandlerInterceptorAdapter {

    private final UserUseCase userUseCase;
    private final SessionUseCase sessionUseCase;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object h) throws IOException {
        Optional<Cookie> userCookie = CookieHelper.findCookie(req, USER);
        Optional<Cookie> sessionCookie = CookieHelper.findCookie(req, SESSION);

        if (!userCookie.isPresent()) {

            try {
                sessionUseCase.verifySession(sessionCookie.get().getValue());
            } catch (ValidationException e) {
                throw new UnauthorizedException(e);
            }

            UserEntity user = userUseCase.createUser(sessionCookie.get().getValue());
            res.addCookie(new Cookie(USER, user.getId()));
            res.sendRedirect(req.getRequestURI());
            return false;
        }

        return true;
    }

}
