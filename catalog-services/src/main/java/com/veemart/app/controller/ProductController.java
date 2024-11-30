package com.veemart.app.controller;

import com.veemart.app.dto.ProductDto;
import com.veemart.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/{name}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createProduct(@RequestBody List<ProductDto> productDtoList, @PathVariable("name") String catalogName) {
        return productService.createProduct(productDtoList, catalogName);
    }

    @RequestMapping(path = "/{sku}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable("sku") String productSku) {
        return productService.delateProduct(productSku);
    }

    @RequestMapping(path = "/{sku}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getProduct(@PathVariable("sku") String productSku) {
        return productService.getProduct(productSku);
    }

    @RequestMapping(path = "/{sku}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String updateProduct(@PathVariable("sku") String productSku, @RequestBody ProductDto productDto) {
        return productService.updateProduct(productSku, productDto);
    }

    @RequestMapping(path = "/List/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getProductList(@PathVariable("name") String catalogName) {
        return productService.getAllProducts(catalogName);
    }
    @RequestMapping(path="/{sku}/{quantity}",method = RequestMethod.PUT)
    public String updateProductQuantity(@PathVariable("sku") String productSku,@PathVariable("quantity")int quantity){
        return productService.updateProductQuantity(productSku, quantity);
    }
}

