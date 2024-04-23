package com.texas.ecs.Ecommerce.repo;

import com.texas.ecs.Ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
