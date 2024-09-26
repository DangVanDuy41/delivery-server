package com.example.deliveryserver.controller;

import com.example.deliveryserver.dto.ApiResponse;
import com.example.deliveryserver.entity.Category;
import com.example.deliveryserver.service.category.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/categories/public")
public class CategoryController {


    private final  CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public ApiResponse<List<Category>> getList (){
        return ApiResponse.<List<Category>>builder()
                .data(categoryService.getList())
                .message("success")
                .time(new Date())
                .build();
    }
}
