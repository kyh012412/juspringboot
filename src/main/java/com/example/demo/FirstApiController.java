package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApiController {
    @GetMapping("/api/hello")//url 맵핑
    public String hello(){
        return "hello world";
    }
}
