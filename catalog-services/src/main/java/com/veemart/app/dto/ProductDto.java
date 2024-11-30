package com.veemart.app.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private float price;
    private float discountedPrice;
    private int quantity;
    private String sku;
    private String quantityType;
    private String category;
    private String imageUrl;

}

