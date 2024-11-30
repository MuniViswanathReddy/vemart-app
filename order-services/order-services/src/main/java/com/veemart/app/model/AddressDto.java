package com.veemart.app.model;

import lombok.Data;

@Data
public class AddressDto {
    private String addressType;
    private String street1;
    private String street2;
    private String cityOrTown;
    private String district;
    private String state;
    private String country;
    private int pinCode;
    private Boolean primary;
}
