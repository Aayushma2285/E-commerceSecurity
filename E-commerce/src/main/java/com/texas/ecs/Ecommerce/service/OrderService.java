package com.texas.ecs.Ecommerce.service;

import com.texas.ecs.Ecommerce.dto.OrderDto;
import com.texas.ecs.Ecommerce.dto.ProductDto;
import com.texas.ecs.Ecommerce.model.Order;
import com.texas.ecs.Ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {
    Integer save(OrderDto orderDto);
    OrderDto getbyId(Integer id);
}
