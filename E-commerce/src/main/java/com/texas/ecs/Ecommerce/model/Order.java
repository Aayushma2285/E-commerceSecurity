package com.texas.ecs.Ecommerce.model;

import jakarta.persistence.*;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    private Integer quantity;

    public Order() {
    }
    public Order(User user_id, Product product, Integer quantity) {
        this.user_id = user_id;
        this.product = product;
        this.quantity = quantity;
    }

    public Order(User user_id, Product product) {
        this.user_id = user_id;
        this.product = product;
    }

    public Order(Integer id, User user_id, Product product, Integer quantity) {
        this.id = id;
        this.user_id = user_id;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getOrderNumber() {
        return id;
    }

    public void setOrderNumber(Integer id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}