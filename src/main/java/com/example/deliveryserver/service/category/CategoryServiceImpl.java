package com.example.deliveryserver.service.category;

import com.example.deliveryserver.entity.Category;
import com.example.deliveryserver.repository.CategoryRepository;
import com.example.deliveryserver.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseService<Category, CategoryRepository> implements CategoryService {

    public CategoryServiceImpl(CategoryRepository repo) {
        super(repo);
    }
}
