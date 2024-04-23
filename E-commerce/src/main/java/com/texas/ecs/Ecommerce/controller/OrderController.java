package com.texas.ecs.Ecommerce.controller;

import com.texas.ecs.Ecommerce.dto.OrderDto;
import com.texas.ecs.Ecommerce.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/save")
    public ResponseEntity saveOrder(@RequestBody OrderDto orderDto){
        Integer id = orderService.save(orderDto);
        return ResponseEntity.ok(Map.of("message","Order Saved Successfully.."));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity fetchUserById(@PathVariable("id") Integer id){
        OrderDto data = orderService.getbyId(id);
        return ResponseEntity.ok(
                Map.of("message","Order Fetched Successfully..","data",data)
        );
    }
}
