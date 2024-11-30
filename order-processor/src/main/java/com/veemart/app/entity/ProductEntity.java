package com.veemart.app.entity;

import lombok.Data;

@Data
public class ProductEntity {
    private String name;
    private float unitPrice;
    private int quantity;
    private float amount;
    private String sku;
}
