package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.entity.Product;
import com.poly.truongnvph29176.repository.ProductRepository;
import com.poly.truongnvph29176.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findByCategoryId(String categoryId, Pageable pageable) {
        return productRepository.findByCategoryId(categoryId, pageable);
    }
}
