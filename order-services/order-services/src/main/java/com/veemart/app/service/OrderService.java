package com.veemart.app.service;

import com.veemart.app.entity.AddressEntity;
import com.veemart.app.entity.OrderEntity;
import com.veemart.app.entity.CustomerEntity;
import com.veemart.app.mapper.Mapper;
import com.veemart.app.model.*;
import com.veemart.app.entity.ProductEntity;
import com.veemart.app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    Mapper mapper;

    @Transactional
    public String placeOrder(OrderDto orderDto) {
        String url = "http://localhost:8082/customer/" + orderDto.getCustomerPhoneNo();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        HttpEntity<CustomerEntity> httpEntity = new HttpEntity<CustomerEntity>(headers);
        CustomerDto customerDto = restTemplate.exchange(url, HttpMethod.GET, httpEntity, CustomerDto.class).getBody();
        CustomerEntity customerEntity = new CustomerEntity();
        List<AddressDto> addressDtoList = customerDto.getAddress();
        Iterator<AddressDto> iterator = addressDtoList.iterator();
        while (iterator.hasNext()) {
            AddressDto addressDto = iterator.next();
            if (addressDto.getPrimary()) {
                AddressEntity addressEntity = mapper.mapAddressEntity(addressDto);
                customerEntity.setShippingAddress(addressEntity);
            } else {
                iterator.remove();
            }
        }
        List<OrderedProduct> orderedProductList = orderDto.getOrderedProducts();
        List<ProductEntity> productEntityList = new ArrayList<ProductEntity>();
        float totalPrice = 0;
        for (OrderedProduct orderedProduct : orderedProductList) {
            String url1 = "http://localhost:8080/product/" + orderedProduct.getSku();
            HttpHeaders headers1 = new HttpHeaders();
            headers1.set("Accept", "application/json");
            HttpEntity<ProductEntity> httpEntity1 = new HttpEntity<ProductEntity>(headers1);
            ProductDto productDto = restTemplate.exchange(url1, HttpMethod.GET, httpEntity1, ProductDto.class).getBody();
            productDto.setQuantity(orderedProduct.getQuantity());
            productDto.setAmount(productDto.getDiscountedPrice() * orderedProduct.getQuantity());
            ProductEntity productEntity = mapper.mapProductEntity(productDto);
            productEntityList.add(productEntity);
            totalPrice = totalPrice + productEntity.getAmount();

        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(UUID.randomUUID().toString());
        orderEntity.setOrderStatus("Ordered");
        orderEntity.setProducts(productEntityList);
        orderEntity.setCustomer(customerEntity);
        orderEntity.setTotalAmount(totalPrice);
        orderRepository.save(orderEntity);
        return "Order Placed "+" Order Id : "+orderEntity.getOrderId();

    }
}
