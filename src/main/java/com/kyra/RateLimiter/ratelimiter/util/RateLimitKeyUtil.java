package com.kyra.RateLimiter.ratelimiter.util;

import jakarta.servlet.http.HttpServletRequest;

public class RateLimitKeyUtil {
    public static String resolveKey(HttpServletRequest request) {
        return request.getRemoteAddr();
    }
}
