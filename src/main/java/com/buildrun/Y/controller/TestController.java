package com.buildrun.Y.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Test endpoint";
    }
}
