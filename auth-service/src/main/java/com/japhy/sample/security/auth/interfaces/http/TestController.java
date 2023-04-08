package com.japhy.sample.security.auth.interfaces.http;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    @SecurityRequirement(name = "bearer-key")
    public String test(){
        return "test";
    }
}
