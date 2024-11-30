package com.veemart.app.mapper;

import com.veemart.app.entity.AddressEntity;
import com.veemart.app.entity.CustomerEntity;
import com.veemart.app.entity.ProductEntity;
import com.veemart.app.model.AddressDto;
import com.veemart.app.model.CustomerDto;
import com.veemart.app.model.ProductDto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public AddressEntity mapAddressEntity(AddressDto addressDto) {
       AddressEntity addressEntity = new AddressEntity();
       addressEntity.setAddressType(addressDto.getAddressType());
       addressEntity.setStreet1(addressDto.getStreet1());
       addressEntity.setStreet2(addressDto.getStreet2());
       addressEntity.setCityOrTown(addressDto.getCityOrTown());
       addressEntity.setState(addressDto.getState());
       addressEntity.setDistrict(addressDto.getDistrict());
       addressEntity.setState(addressDto.getState());
       addressEntity.setCountry(addressDto.getCountry());
       addressEntity.setPinCode(addressDto.getPinCode());
       return addressEntity;
    }

    public ProductEntity mapProductEntity(ProductDto productDto) {
       ProductEntity productEntity = new ProductEntity();
       productEntity.setName(productDto.getName());
       productEntity.setQuantity(productDto.getQuantity());
       productEntity.setUnitPrice(productDto.getDiscountedPrice());
       productEntity.setAmount(productDto.getAmount());
       productEntity.setSku(productDto.getSku());
       return productEntity;
    }
}
