package com.texas.ecs.Ecommerce.dto;

public class OrderDto {
    private Long orderNumber;
    private Integer id;
    private Integer user_id;
    private Integer product_id;
    private Integer quantity;

    public OrderDto(Integer user_id, Integer product_id, Integer quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public OrderDto(Integer id, Integer user_id, Integer product_id, Integer quantity) {
        this.id = id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public OrderDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
