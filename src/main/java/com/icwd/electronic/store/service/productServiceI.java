package com.icwd.electronic.store.service;

import com.icwd.electronic.store.dto.PageableResponse;
import com.icwd.electronic.store.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface productServiceI {

public ProductDto createProduct(ProductDto productDto);

public ProductDto updateProduct(ProductDto productDto, String productId);

public PageableResponse<ProductDto> getAllProduct(Integer pageNumber, Integer pageSize);

public ProductDto getProduct(String productId);


}
