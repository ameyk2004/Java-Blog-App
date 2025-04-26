package com.ameyTech.blog.controller;

import com.ameyTech.blog.domain.dto.CategoryDto;
import com.ameyTech.blog.domain.dto.CreateCategoryRequest;
import com.ameyTech.blog.domain.model.Category;
import com.ameyTech.blog.mappers.CategoryMapper;
import com.ameyTech.blog.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listAllCategories(){
        List<Category> categories = categoryService.listCategories();

        return ResponseEntity.ok(categories.stream().map(categoryMapper::toDto).toList());

    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){

        Category categoryToCreate = categoryMapper.toEntity(createCategoryRequest);
        Category savedCategory = categoryService.createCategory(categoryToCreate);

        return new ResponseEntity<>(
                categoryMapper.toDto(savedCategory),
                HttpStatus.CREATED
        );

    }
}
