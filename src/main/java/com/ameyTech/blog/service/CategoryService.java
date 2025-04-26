package com.ameyTech.blog.service;

import com.ameyTech.blog.domain.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> listCategories();
    Category createCategory(Category categoryToCreate);
}
