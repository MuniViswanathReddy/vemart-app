package com.veemart.app.entity;

import lombok.Data;

@Data
public class CustomerEntity {
    private String name;
    private String phone;
    private AddressEntity shippingAddress;
}
