package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.entity.Product;
import com.poly.truongnvph29176.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/list")
    public String getAllProduct(Model model,
                                @RequestParam(defaultValue = "0", name = "page") Integer number,
                                @RequestParam("category")Optional<String> categoryId) {
        Pageable pageable = PageRequest.of(number, 12);
        if(categoryId.isPresent()) {
            Page<Product> listProduct = productService.findByCategoryId(categoryId.get(), pageable);
            model.addAttribute("listProduct", listProduct);
        }else {
            Page<Product> listProduct = productService.findAllProduct(pageable);
            model.addAttribute("listProduct", listProduct);
        }
        return "product/list";
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(Model model, @PathVariable("id") Integer id) {
        Product idProduct = productService.findById(id);
        model.addAttribute("product", idProduct);
        return "product/detail";
    }
}
