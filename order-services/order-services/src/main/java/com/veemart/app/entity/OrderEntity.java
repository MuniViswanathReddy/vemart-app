package com.veemart.app.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;


@Data
@Document(collection = "orders")
public class OrderEntity {
    @MongoId
    private String orderId;
    private String orderStatus;
    private List<ProductEntity> products;
    private float totalAmount;
    private CustomerEntity customer;
}
