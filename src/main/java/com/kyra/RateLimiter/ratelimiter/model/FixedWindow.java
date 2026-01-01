package com.kyra.RateLimiter.ratelimiter.model;

public class FixedWindow {
    public int limit;
    public long windowSizeMillis;

    public FixedWindow(int limit, long windowSizeMillis) {
        this.limit = limit;
        this.windowSizeMillis = windowSizeMillis;
    }
}
