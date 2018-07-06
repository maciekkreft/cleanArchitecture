package com.application.entrypoints.rest.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Stream;

public class CookieHelper {
    public static Optional<Cookie> findCookie(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();
        return cookies == null
                ? Optional.empty()
                : Stream.of(cookies)
                .filter(c -> c.getName().equals(name))
                .findFirst();
    }
}
