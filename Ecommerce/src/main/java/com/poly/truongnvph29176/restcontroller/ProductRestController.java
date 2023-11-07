package com.poly.truongnvph29176.restcontroller;

import com.poly.truongnvph29176.entity.Product;
import com.poly.truongnvph29176.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class ProductRestController {
    private final ProductService productService;

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Integer id) {
        return productService.findById(id);
    }
}
