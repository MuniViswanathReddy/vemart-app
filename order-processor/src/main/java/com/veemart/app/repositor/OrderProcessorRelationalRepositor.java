package com.veemart.app.repositor;

import com.veemart.app.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderProcessorRelationalRepositor extends CrudRepository<ProductEntity, Long> {
}
