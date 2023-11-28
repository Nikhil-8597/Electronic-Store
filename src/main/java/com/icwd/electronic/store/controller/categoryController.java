package com.icwd.electronic.store.controller;

import com.icwd.electronic.store.constants.AppConstants;
import com.icwd.electronic.store.dto.CategoryDto;
import com.icwd.electronic.store.dto.ApiResponse;
import com.icwd.electronic.store.service.categoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class categoryController {

    @Autowired
    private categoryService service;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCat(@RequestBody CategoryDto categoryDto){
        CategoryDto category = this.service.createCategory(categoryDto);
        return  new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    @PostMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCat(@RequestBody CategoryDto categoryDto, @PathVariable String categoryId){
        CategoryDto categoryDto1 = this.service.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<>(categoryDto1,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCat(){
       List<CategoryDto> allCat = this.service.getAllCategories();
        return new ResponseEntity<>(allCat,HttpStatus.OK);
    }
    @GetMapping("/{categoryId}")
     public ResponseEntity<CategoryDto> singleCategory(@PathVariable String categoryId){
        CategoryDto singleCategory = this.service.getSingleCategory(categoryId);
        return new ResponseEntity<>(singleCategory,HttpStatus.OK);
    }
     @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable String categoryId){
        this.service.deleteCategory(categoryId);
         ApiResponse apiResponse = ApiResponse.builder().message(AppConstants.DELETED_SUCCESSFULLY).success(true).status(HttpStatus.OK).build();
         return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
