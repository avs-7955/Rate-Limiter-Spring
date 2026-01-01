package com.kyra.RateLimiter.config;

import com.kyra.RateLimiter.ratelimiter.core.FixedWindowCounterRateLimiter;
import com.kyra.RateLimiter.ratelimiter.core.RateLimiter;
import com.kyra.RateLimiter.ratelimiter.model.FixedWindowConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RateLimiterConfig {

    @Bean
    public RateLimiter rateLimiter() {
        return new FixedWindowCounterRateLimiter(new FixedWindowConfig(2, 10_000));
    }
}
