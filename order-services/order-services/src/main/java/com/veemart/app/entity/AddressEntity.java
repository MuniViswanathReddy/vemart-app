package com.veemart.app.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@EqualsAndHashCode(of = {"addressType"})
public class AddressEntity {
    private String addressType;
    private String street1;
    private String street2;
    private String cityOrTown;
    private String district;
    private String state;
    private String country;
    private int pinCode;
}
