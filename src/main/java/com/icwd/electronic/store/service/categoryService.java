package com.icwd.electronic.store.service;

import com.icwd.electronic.store.dto.CategoryDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface categoryService {

    // create category
    public CategoryDto createCategory(CategoryDto categoryDto);
    // updateCategory
    public CategoryDto  updateCategory (CategoryDto categoryDto, String categoryId );
    // getAllCategories
    public List<CategoryDto> getAllCategories();
    //getSingleCategory
    public CategoryDto getSingleCategory(String categoryId);
    //deleteCategory
    public void deleteCategory(String categoryId);
}
