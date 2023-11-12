package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> findAllProduct(Pageable pageable);
    List<Product> findAll();
    Product findById(Integer id);
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Page<Product> findByCategoryId(String categoryId, Pageable pageable);
}
