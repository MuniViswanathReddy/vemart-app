package com.veemart.app.mapper;

import com.veemart.app.dto.ProductDto;
import com.veemart.app.entity.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ProductEntity productEntityMapper(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDto.getId());
        productEntity.setName(productDto.getName());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setDiscountedPrice(productDto.getDiscountedPrice());
        productEntity.setCategory(productDto.getCategory());
        productEntity.setImageUrl(productDto.getImageUrl());
        productEntity.setQuantity(productDto.getQuantity());
        productEntity.setQuantityType(productDto.getQuantityType());
        productEntity.setSku(productDto.getSku());
        return productEntity;
    }

    public ProductDto productDtoMapper(ProductEntity productEntity) {
        ProductDto productDto = new ProductDto();
        productDto.setId(productEntity.getId());
        productDto.setName(productEntity.getName());
        productDto.setPrice(productEntity.getPrice());
        productDto.setDescription(productEntity.getDescription());
        productDto.setDiscountedPrice(productEntity.getDiscountedPrice());
        productDto.setCategory(productEntity.getCategory());
        productDto.setImageUrl(productEntity.getImageUrl());
        productDto.setQuantity(productEntity.getQuantity());
        productDto.setQuantityType(productEntity.getQuantityType());
        productDto.setSku(productEntity.getSku());
        return productDto;
    }
}
