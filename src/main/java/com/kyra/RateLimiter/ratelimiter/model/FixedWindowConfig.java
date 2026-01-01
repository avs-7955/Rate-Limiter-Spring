package com.kyra.RateLimiter.ratelimiter.model;

public class FixedWindowConfig {
    public int limit;
    public long windowSizeMillis;

    public FixedWindowConfig(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
    }
}
