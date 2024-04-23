package com.texas.ecs.Ecommerce.service.impl;

import com.texas.ecs.Ecommerce.dto.OrderDto;
import com.texas.ecs.Ecommerce.model.Order;
import com.texas.ecs.Ecommerce.model.Product;
import com.texas.ecs.Ecommerce.model.User;
import com.texas.ecs.Ecommerce.repo.OrderRepo;
import com.texas.ecs.Ecommerce.repo.ProductRepo;
import com.texas.ecs.Ecommerce.repo.UserRepo;
import com.texas.ecs.Ecommerce.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;
    private final UserRepo userRepo;

    public OrderServiceImpl(OrderRepo orderRepo, ProductRepo productRepo, UserRepo userRepo){
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.userRepo = userRepo;
    }
    @Override
    public Integer save(OrderDto orderDto) {
        Order order = new Order();
        Product product = productRepo.findById(orderDto.getProduct_id()).orElseThrow(() -> new RuntimeException("Product not found"));
        order.setProduct(product);
        User user = userRepo.findById(orderDto.getUser_id()).orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser_id(user);
        order.setQuantity(orderDto.getQuantity());
        Order savedOrder = orderRepo.save(order);
        return savedOrder.getOrderNumber();
    }

    @Override
    public OrderDto getbyId(Integer id) {
        return null;
    }
}
