package com.kyra.RateLimiter.ratelimiter.core;

import com.kyra.RateLimiter.ratelimiter.model.FixedWindowConfig;
import com.kyra.RateLimiter.ratelimiter.model.Window;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowCounterRateLimiter implements RateLimiter {

    private final FixedWindowConfig fixedWindowConfig;
    private final Map<String, Window> store = new HashMap<>();

    public FixedWindowCounterRateLimiter(FixedWindowConfig fixedWindowConfig) {
        this.fixedWindowConfig = fixedWindowConfig;
    }

    @Override
    public synchronized boolean allowRequest(String key) {
        long now = System.currentTimeMillis();

        Window window = store.getOrDefault(key, new Window(now, 0));
        if (now - window.startTime >= fixedWindowConfig.windowSizeMillis) {
            window = new Window(now, 0);
        }
        if (window.count >= fixedWindowConfig.limit) {
            return false;
        }
        window.count++;
        store.put(key, window);
        return true;
    }
}
