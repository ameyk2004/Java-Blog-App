package com.ameyTech.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories/")
@RequiredArgsConstructor
public class CategoryController {

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listAllCategories(){
        //TODO
    }
}
