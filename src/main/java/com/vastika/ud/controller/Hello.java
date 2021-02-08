package com.vastika.ud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Hello {

    @GetMapping("/greet")
    public String sayHello(){
        return "hi";
    }
}
