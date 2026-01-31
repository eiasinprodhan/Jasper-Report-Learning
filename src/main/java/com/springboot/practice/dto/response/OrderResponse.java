package com.springboot.practice.dto.response;

import java.time.LocalDateTime;

public class OrderResponse {
    private Long id;
    private String product;
    private Double price;
    private LocalDateTime orderDate;
    private Long userId;

    public OrderResponse() {
    }

    public OrderResponse(Long id, String product, Double price, LocalDateTime orderDate, Long userId) {
        this.id = id;
        this.product = product;
        this.price = price;
        this.orderDate = orderDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
