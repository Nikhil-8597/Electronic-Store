package com.icwd.electronic.store.service.Impl;

import com.icwd.electronic.store.constants.AppConstants;
import com.icwd.electronic.store.dto.PageableResponse;
import com.icwd.electronic.store.dto.ProductDto;
import com.icwd.electronic.store.entity.Product;
import com.icwd.electronic.store.exception.ResourceNotFoundException;
import com.icwd.electronic.store.helper.Helper;
import com.icwd.electronic.store.repository.ProductRepo;
import com.icwd.electronic.store.service.productServiceI;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class productServiceImpl implements productServiceI {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        String productID = UUID.randomUUID().toString();
        productDto.setProductId(productID);
        productDto.setAddeddate(new Date());
        Product product = this.modelMapper.map(productDto, Product.class);
        Product product1 = this.productRepo.save(product);
        return this.modelMapper.map(product1, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, String productId) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + productId));
        product.setTitle(productDto.getTitle());
        product.setLive(productDto.getLive());
        product.setAddeddate(productDto.getAddeddate());
        product.setDescription(productDto.getDescription());
        product.setDescountprice(productDto.getDescountprice());
        product.setQuantity(productDto.getQuantity());
        product.setProductimagename(productDto.getProductimagename());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        Product product1 = this.productRepo.save(product);
        return this.modelMapper.map(product1, ProductDto.class);
    }

    @Override
    public PageableResponse<ProductDto> getAllProduct( Integer pageNumber,  Integer pageSize ) {


        Pageable pageable = PageRequest.of(pageNumber , pageSize);
        Page<Product> all = this.productRepo.findAll(pageable);
        PageableResponse<ProductDto> dtoPageableResponse = Helper.getPageableResponse(all, ProductDto.class);
        return dtoPageableResponse;
    }

    @Override
    public ProductDto getProduct(String productId) {
        Product product = this.productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException(AppConstants.NOT_FOUND + productId));
        return this.modelMapper.map(product, ProductDto.class);
    }
}
