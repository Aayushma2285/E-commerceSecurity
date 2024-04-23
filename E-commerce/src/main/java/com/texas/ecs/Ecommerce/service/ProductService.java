package com.texas.ecs.Ecommerce.service;

import com.texas.ecs.Ecommerce.dto.ProductDto;
import com.texas.ecs.Ecommerce.dto.UserDto;
import com.texas.ecs.Ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    Integer save(ProductDto productDto);
    ProductDto getbyId(Integer id);
    List<ProductDto> getAll();
    void deleteById();
    Product getProduct(Integer id);
}
