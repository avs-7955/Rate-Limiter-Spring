package com.kyra.RateLimiter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test-rate")
public class TestController {

    @GetMapping
    public ResponseEntity<String> getUserPing() {
        String message = "Hi, You are able to reach the server!";
        return ResponseEntity.ok(message);
    }
}
