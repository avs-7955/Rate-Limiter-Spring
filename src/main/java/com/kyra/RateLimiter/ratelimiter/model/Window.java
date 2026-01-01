package com.kyra.RateLimiter.ratelimiter.model;

public class Window {
    public long startTime;
    public int count;

    public Window(long startTime, int count) {
        this.startTime = startTime;
        this.count = count;
    }
}
