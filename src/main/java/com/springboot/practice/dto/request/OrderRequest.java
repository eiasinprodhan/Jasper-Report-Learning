package com.springboot.practice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderRequest {

    @NotBlank(message = "Product is required")
    private String product;

    @NotNull(message = "price is required")
    private Double price;

    @NotNull(message = "User ID is required")
    private Long userId;

    public OrderRequest() {
    }

    public OrderRequest(String product, Double price, Long userId) {
        this.product = product;
        this.price = price;
        this.userId = userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
