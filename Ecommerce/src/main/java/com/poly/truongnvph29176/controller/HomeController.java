package com.poly.truongnvph29176.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "layout/home";
    }

    @GetMapping("/contact")
    public String contact() {
        return "layout/contact";
    }
}
