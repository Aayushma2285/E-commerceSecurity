package com.texas.ecs.Ecommerce.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @SequenceGenerator(name = "product_seq",sequenceName = "product_seq",allocationSize = 1,initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "price", nullable = false)
    private Integer price;

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public Product(Integer id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
