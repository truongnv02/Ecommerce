package com.poly.truongnvph29176.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/list")
    public String getAllOrder() {

        return "order/list";
    }

    @GetMapping("/checkout")
    public String checkOut() {

        return "order/checkout";
    }

    @GetMapping("/detail/{id}")
    public String orderDetail(@PathVariable("id") Long id) {

        return "order/detail";
    }
}
