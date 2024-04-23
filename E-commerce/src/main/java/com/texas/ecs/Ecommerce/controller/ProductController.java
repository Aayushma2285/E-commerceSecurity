package com.texas.ecs.Ecommerce.controller;

import com.texas.ecs.Ecommerce.dto.ProductDto;
import com.texas.ecs.Ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity saveUser(@RequestBody ProductDto productDto){
        Integer id = productService.save(productDto);
        return ResponseEntity.ok(Map.of("message","Product Saved Successfully.."));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") Integer id){
        ProductDto data = productService.getbyId(id);
        return ResponseEntity.ok(
                Map.of("message","Product Fetched Successfully..","data",data)
        );
    }
    @GetMapping("/list")
    public ResponseEntity fetchAllUsers(){
        List<ProductDto> data = productService.getAll();
        return ResponseEntity.ok(
                Map.of("message","Product List Fetched Successfully..","data",data)
        );
    }
}
