package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Product> findAllProduct(Pageable pageable);
    Product findById(Integer id);

    Page<Product> findByCategoryId(String categoryId, Pageable pageable);
}
