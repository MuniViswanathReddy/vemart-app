package com.veemart.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
    @Column(name = "product_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private float price;
    @Column(name = "discount_price")
    private float discountedPrice;
    @Column(name = "quantity")
    private int quantity;
    @Id
    @Column(name = "sku")
    private String sku;
    @Column(name = "quantity_type")
    private String quantityType;
    @Column(name = "category")
    private String category;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "catalog_name")
    private String catalogyName;
}

