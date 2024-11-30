package com.veemart.app.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerEntity {
    private String name;
    private String phone;
    private AddressEntity shippingAddress;
}
