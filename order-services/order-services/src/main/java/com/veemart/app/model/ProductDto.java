package com.veemart.app.model;

import lombok.Data;

@Data
public class ProductDto {
    private String name;
    private float discountedPrice;
    private int quantity;
    private float amount;
    private String sku;
}
