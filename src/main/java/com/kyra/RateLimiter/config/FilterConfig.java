package com.kyra.RateLimiter.config;

import com.kyra.RateLimiter.filter.RateLimitFilter;
import com.kyra.RateLimiter.ratelimiter.core.RateLimiter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<RateLimitFilter> rateLimitFilter(
            RateLimiter rateLimiter) {

        RateLimitFilter filter = new RateLimitFilter(rateLimiter);

        FilterRegistrationBean<RateLimitFilter> registrationBean =
                new FilterRegistrationBean<>();

        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return registrationBean;
    }
}
