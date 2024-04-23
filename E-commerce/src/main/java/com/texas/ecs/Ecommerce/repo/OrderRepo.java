package com.texas.ecs.Ecommerce.repo;

import com.texas.ecs.Ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
