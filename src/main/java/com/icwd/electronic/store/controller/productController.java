package com.icwd.electronic.store.controller;

import com.icwd.electronic.store.constants.AppConstants;
import com.icwd.electronic.store.dto.PageableResponse;
import com.icwd.electronic.store.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.icwd.electronic.store.service.productServiceI;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private productServiceI productServiceI;

    @PostMapping("/")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto product = this.productServiceI.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto, @PathVariable String productId){
        ProductDto productDto1 = this.productServiceI.updateProduct(productDto, productId);
        return new ResponseEntity<>(productDto1,HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<PageableResponse<ProductDto>> getAllProduct(
            @RequestParam(value = "pageNumber" , defaultValue = AppConstants.PAGE_NUMBER , required = false)Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false)Integer pageSize
            ){

        PageableResponse<ProductDto> allProduct = this.productServiceI.getAllProduct(pageNumber, pageSize);

        return new ResponseEntity<>(allProduct,HttpStatus.OK);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable String productId){
        ProductDto product = this.productServiceI.getProduct(productId);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

}
