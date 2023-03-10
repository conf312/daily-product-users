package com.daily.product.users.common;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserCookie {
    // 30분
    private final int ACCESS_TOKEN_SECOND = 60 * 30;
    // 7일
    private final int REFRESH_TOKEN_SECOND = 60 * 60 * 24 * 7;

    public void setAccessToken(HttpServletResponse response, String value) {
        Cookie cookie = new Cookie("accessToken", value);
        cookie.setMaxAge(ACCESS_TOKEN_SECOND);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    public void setRefreshToken(HttpServletResponse response, String value) {
        Cookie cookie = new Cookie("refreshToken", value);
        cookie.setMaxAge(REFRESH_TOKEN_SECOND);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    public String getRefreshToken(Cookie[] cookies) {
        if (cookies == null) throw new NullPointerException("==> getRefreshToken Empty Cookie.");
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("refreshToken"))
                return cookie.getValue();
        }
        return "";
    }
}
