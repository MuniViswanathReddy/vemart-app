package com.veemart.app.service;

import com.veemart.app.entity.OrderEntity;
import com.veemart.app.entity.ProductEntity;
import com.veemart.app.model.OrderedProductKey;
import com.veemart.app.repositor.OrderProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class OrderedProcessorService {
    @Autowired
    OrderProcessorRepository orderProcessorRepository;
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public String updateProductQuantityAndOrderStatus(OrderedProductKey orderProductKey) {

        Optional<OrderEntity> optional = orderProcessorRepository.findById(orderProductKey.getOrderId());
        if (optional.isPresent()) {
            OrderEntity orderEntity = optional.get();
            if (orderEntity.getOrderStatus().equals("Ordered")) {
                orderEntity.setOrderStatus("order Accepted");
            } else {
                throw new RuntimeException("Order Status is already accepted");
            }
            List<ProductEntity> productEntityList = orderEntity.getProducts();
            Iterator<ProductEntity> iterator = productEntityList.iterator();
            while (iterator.hasNext()) {
                ProductEntity productEntity = iterator.next();
                String url = "http://localhost:8080/product/" + productEntity.getSku() + "/" + productEntity.getQuantity();
                HttpHeaders headers = new HttpHeaders();
                headers.add("Accept", "application/json");
                HttpEntity<ProductEntity> entity = new HttpEntity<ProductEntity>(headers);
                restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
            }
            orderProcessorRepository.save(orderEntity);
        } else {
            throw new RuntimeException("Order Not Found");
        }
        return "Order Updated Successfully";
    }
}
