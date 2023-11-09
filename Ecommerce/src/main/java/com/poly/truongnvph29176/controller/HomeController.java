package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.entity.Product;
import com.poly.truongnvph29176.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ProductService productService;

    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 8, Sort.by("id").descending());
        Page<Product> listProduct = productService.findAllProduct(pageable);
        model.addAttribute("listProduct", listProduct);

        return "layout/home";
    }

    @GetMapping("/contact")
    public String contact() {
        return "layout/contact";
    }

    @GetMapping("/blog")
    public String blog() {
        return "layout/blog";
    }
}
