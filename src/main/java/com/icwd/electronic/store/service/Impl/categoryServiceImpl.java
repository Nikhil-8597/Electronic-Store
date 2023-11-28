package com.icwd.electronic.store.service.Impl;

import com.icwd.electronic.store.constants.AppConstants;
import com.icwd.electronic.store.dto.CategoryDto;
import com.icwd.electronic.store.dto.UserDto;
import com.icwd.electronic.store.entity.Category;
import com.icwd.electronic.store.entity.User;
import com.icwd.electronic.store.exception.ResourceNotFoundException;
import com.icwd.electronic.store.repository.categoryRepository;
import com.icwd.electronic.store.service.categoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class categoryServiceImpl implements categoryService {
    @Autowired
    private categoryRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        String string = UUID.randomUUID().toString();
        categoryDto.setCategoryId(string);
        Category category1 = mapper.map(categoryDto, Category.class);
        Category save = this.repository.save(category1);
        CategoryDto categoryDto1 = mapper.map(save, CategoryDto.class);
        return categoryDto1;

    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, String categoryId) {

        Category category = this.repository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + categoryId));
        //category.setCategoryId(categoryDto.getCategoryId());
        category.setTitle(categoryDto.getTitle());
        category.setDescription(categoryDto.getDescription());
        category.setCoverImage(categoryDto.getCoverImage());
        Category save = this.repository.save(category);
        CategoryDto categoryDto1 = this.mapper.map(save, CategoryDto.class);
        return categoryDto1;


    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = this.repository.findAll();
        List<CategoryDto> categoryDtoList = categoryList.stream().map(category -> mapper.map(category, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtoList;
    }

    @Override
    public CategoryDto getSingleCategory(String categoryId) {
        Category category = this.repository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND));
        CategoryDto categoryDto = this.mapper.map(category, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public void deleteCategory(String categoryId) {
        Category category = this.repository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND));

            this.repository.deleteById(categoryId);


    }
}
