package com.vin.learn_spring_security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Products
{
    @GetMapping("/king-vinay")
    public String hi() {
        return "King Vinay";
    }
}
