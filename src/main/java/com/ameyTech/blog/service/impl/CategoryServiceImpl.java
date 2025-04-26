package com.ameyTech.blog.service.impl;

import com.ameyTech.blog.domain.model.Category;
import com.ameyTech.blog.repository.CategoryRepository;
import com.ameyTech.blog.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category categoryToCreate) {

        if(categoryRepository.existsByNameIgnoreCase(categoryToCreate.getName())){
            throw new IllegalArgumentException("Category already exists "+categoryToCreate.getName());
        }

        return categoryRepository.save(categoryToCreate);
    }

    @Override
    public void deleteCategory(UUID id) {
        Optional<Category> categoryToDelete = categoryRepository.findById(id);
        if(categoryToDelete.isPresent()){
            if(!categoryToDelete.get().getPosts().isEmpty()){
                throw new IllegalStateException("Category Has Posts Associated with it");
            }
            categoryRepository.deleteById(id);
        }

    }
}
