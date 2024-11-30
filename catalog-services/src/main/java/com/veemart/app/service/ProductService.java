package com.veemart.app.service;

import com.veemart.app.dto.ProductDto;
import com.veemart.app.entity.CatalogEntity;
import com.veemart.app.entity.ProductEntity;
import com.veemart.app.mapper.Mapper;
import com.veemart.app.repository.CatalogRepository;
import com.veemart.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private CatalogRepository catalogRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mapper mapper;

    @Transactional
    public String createProduct(List<ProductDto> productDtoList, String catalog_name) {
        CatalogEntity catalogEntity = catalogRepository.findByName(catalog_name);
        if (catalogEntity == null) {
            return "Catalog does not exist";
        } else {
            List<ProductEntity> productEntityList = new ArrayList<>();
            for (ProductDto productDto : productDtoList) {
                ProductEntity productEntity = mapper.productEntityMapper(productDto);
                productEntity.setCatalogyName(catalog_name);
                productEntityList.add(productEntity);
            }
            productRepository.saveAll(productEntityList);
            return "product created successfully";
        }
    }

    public String delateProduct(String productSku) {
        productRepository.deleteById(productSku);
        return "product deleted successfully";
    }

    @Transactional
    public ProductDto getProduct(String productSku) {
        Optional optional = productRepository.findById(productSku);
        if (optional.isPresent()) {
            ProductEntity productEntity = (ProductEntity) optional.get();
            ProductDto productDto = mapper.productDtoMapper(productEntity);
            return productDto;
        } else {
            throw new RuntimeException("Product is not available with the " + productSku);
        }
    }

    @Transactional
    public String updateProduct(String productSku, ProductDto productDto) {
        Optional optional = productRepository.findById(productSku);
        if (optional.isPresent()) {
            ProductEntity productEntity = (ProductEntity) optional.get();
            productEntity = mapper.productEntityMapper(productDto);
        }
        return "product updated successfully";
    }

    public List<ProductDto> getAllProducts(String catalog_name) {
        CatalogEntity catalogEntity = catalogRepository.findByName(catalog_name);
        if (catalogEntity == null) {
            throw new RuntimeException("Catalog does not exist");
        } else {
            List<ProductEntity> productEntityList = productRepository.findByCatalogyName(catalog_name);
            List<ProductDto> productDtoList = new ArrayList<>();
            for (ProductEntity productEntity : productEntityList) {
                ProductDto productDto = mapper.productDtoMapper(productEntity);
                productDtoList.add(productDto);
            }
            return productDtoList;
        }
    }
    @Transactional
    public String updateProductQuantity(String productSku, int quantity) {
        ProductEntity productEntity = productRepository.findById(productSku).get();
        if(productEntity.getQuantity() >= quantity && productEntity.getQuantity()!=0) {
            productEntity.setQuantity(productEntity.getQuantity() - quantity);
            return "updated product quantity successfully";
        }else{
            throw new RuntimeException("Product is not available with the " + productSku);
        }
    }
}

