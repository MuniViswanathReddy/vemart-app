package com.veemart.app.dao;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@EqualsAndHashCode(of = {"addressType"})
public class AddressInfo {
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

