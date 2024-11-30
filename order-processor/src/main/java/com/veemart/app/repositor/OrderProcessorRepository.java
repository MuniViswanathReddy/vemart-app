package com.veemart.app.repositor;

import com.veemart.app.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProcessorRepository extends MongoRepository<OrderEntity,String> {
}
