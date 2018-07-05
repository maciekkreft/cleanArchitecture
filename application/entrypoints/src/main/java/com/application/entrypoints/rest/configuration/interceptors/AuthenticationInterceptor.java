package com.application.entrypoints.rest.configuration.interceptors;

import com.application.core.session.SessionNotFoundException;
import com.application.core.sheet.UserNotFoundException;
import com.application.core.user.UserEntity;
import com.application.core.user.UserUseCase;
import com.application.core.user.UserWasNotRegisteredWithGivenSessionId;
import com.application.entrypoints.rest.exceptions.NotFoundException;
import com.application.entrypoints.rest.exceptions.UnauthorizedException;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.application.entrypoints.rest.configuration.Constants.Cookie.SESSION;
import static com.application.entrypoints.rest.configuration.Constants.Cookie.USER;
import static com.application.entrypoints.rest.configuration.CookieHelper.findCookie;

@AllArgsConstructor
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    private final UserUseCase userUseCase;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object h) {
        return true;
    }

}
