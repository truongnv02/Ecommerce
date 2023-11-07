package com.poly.truongnvph29176.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/view")
    public String viewCart() {

        return "cart/view";
    }
}
