package com.texas.ecs.Ecommerce.service.impl;

import com.texas.ecs.Ecommerce.dto.ProductDto;
import com.texas.ecs.Ecommerce.dto.UserDto;
import com.texas.ecs.Ecommerce.model.Product;
import com.texas.ecs.Ecommerce.model.User;
import com.texas.ecs.Ecommerce.repo.ProductRepo;
import com.texas.ecs.Ecommerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Integer save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        Product savedProduct = productRepo.save(product);
        return savedProduct.getId();
    }

    @Override
    public ProductDto getbyId(Integer id) {
        Optional<Product> userOptional = productRepo.findById(id);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }
        return null;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> productList = productRepo.findAll();
        List<ProductDto> productDtoList = productList.stream()
                .map(product -> {
                    ProductDto productDto = new ProductDto(
                           product.getId(), product.getName(), product.getPrice()
                    );
                    return productDto;
                }).collect(Collectors.toList());
        return productDtoList;
    }

    @Override
    public void deleteById() {

    }

    @Override
    public Product getProduct(Integer id) {
        return null;
    }

}
