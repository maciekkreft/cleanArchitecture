package com.application.entrypoints.rest.interceptors;

import com.application.core.session.SessionUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static com.application.entrypoints.rest.configuration.Constants.Cookies.SESSION_ID;

@Slf4j
@AllArgsConstructor
public class CreateSessionCookieInterceptor extends HandlerInterceptorAdapter {

    private final SessionUseCase sessionUseCase;
    private final CorsHelper corsHelper;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object h) throws IOException {
        Optional<Cookie> sessionCookie = CookieHelper.findCookie(req, SESSION_ID);

        if (!sessionCookie.isPresent()) {
            String session = sessionUseCase.createSession();
            res.addCookie(new Cookie(SESSION_ID, session));
            corsHelper.addCorsSupport(res);
            res.sendRedirect(req.getRequestURI());
            return false;
        }

        return true;
    }

}
