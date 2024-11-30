package com.veemart.app.model;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private List<OrderedProduct> orderedProducts;
    private String customerPhoneNo;
}
