package com.ameyTech.blog.service.impl;

import com.ameyTech.blog.domain.model.Category;
import com.ameyTech.blog.repository.CategoryRepository;
import com.ameyTech.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }
}
