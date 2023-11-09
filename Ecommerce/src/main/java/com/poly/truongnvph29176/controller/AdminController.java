package com.poly.truongnvph29176.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {

    @RequestMapping({"/", "/home/index"})
    public String home() {
        return "redirect:/product/list";
    }

    @RequestMapping({"/admin", "/admin/home/index"})
    public String admin() {
        return "redirect:/fe/admin/index.html";
    }
}
