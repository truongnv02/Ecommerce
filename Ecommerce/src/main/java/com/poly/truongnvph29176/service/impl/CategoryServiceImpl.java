package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.entity.Category;
import com.poly.truongnvph29176.repository.CategoryRepository;
import com.poly.truongnvph29176.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
}
