package com.application.entrypoints.rest.configuration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Stream;

public class CookieHelper {
    public static Optional<Cookie> findCookie(HttpServletRequest r, String name) {
        Cookie[] cookies = r.getCookies();
        return cookies == null
                ? Optional.empty()
                : Stream.of(cookies)
                .filter(c -> c.getName().equals(name))
                .findFirst();
    }
}
