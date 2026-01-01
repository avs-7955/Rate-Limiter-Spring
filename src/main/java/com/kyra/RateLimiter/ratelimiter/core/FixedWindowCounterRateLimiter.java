package com.kyra.RateLimiter.ratelimiter.core;

import com.kyra.RateLimiter.ratelimiter.model.FixedWindow;
import com.kyra.RateLimiter.ratelimiter.model.Window;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowCounterRateLimiter implements RateLimiter {

    private final FixedWindow fixedWindow;
    private final Map<String, Window> store = new HashMap<>();

    public FixedWindowCounterRateLimiter(FixedWindow fixedWindow) {
        this.fixedWindow = fixedWindow;
    }

    @Override
    public synchronized boolean allowRequest(String key) {
        long now = System.currentTimeMillis();

        Window window = store.getOrDefault(key, new Window(now, 0));
        if (now - window.startTime >= fixedWindow.windowSizeMillis) {
            window = new Window(now, 0);
        }
        if (window.count >= fixedWindow.limit) {
            return false;
        }
        window.count++;
        store.put(key, window);
        return true;
    }
}
