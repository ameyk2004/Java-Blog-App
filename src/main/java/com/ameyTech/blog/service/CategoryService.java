package com.ameyTech.blog.service;

import com.ameyTech.blog.domain.model.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> listCategories();
    Category createCategory(Category categoryToCreate);
    void deleteCategory(UUID id);
}
