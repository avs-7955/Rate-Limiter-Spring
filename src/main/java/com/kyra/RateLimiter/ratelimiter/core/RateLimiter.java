package com.kyra.RateLimiter.ratelimiter.core;

public interface RateLimiter {
    boolean allowRequest(String key);
}
