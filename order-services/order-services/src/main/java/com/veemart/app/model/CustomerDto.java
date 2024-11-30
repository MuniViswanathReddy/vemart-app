package com.veemart.app.model;

import com.veemart.app.entity.AddressEntity;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {
    private String name;
    private String phone;
    private List<AddressDto> address;
}
