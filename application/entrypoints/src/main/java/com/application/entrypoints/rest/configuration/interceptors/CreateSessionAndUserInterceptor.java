package com.application.entrypoints.rest.configuration.interceptors;

import com.application.core.session.SessionUseCase;
import com.application.core.user.UserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static com.application.entrypoints.rest.configuration.Constants.Cookie.SESSION;
import static com.application.entrypoints.rest.configuration.Constants.Cookie.USER;
import static com.application.entrypoints.rest.configuration.CookieHelper.findCookie;

@AllArgsConstructor
public class CreateSessionAndUserInterceptor extends HandlerInterceptorAdapter {

    private final SessionUseCase sessionUseCase;
    private final UserUseCase userUseCase;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object h) throws IOException {
        return true;
    }

}
