package com.veemart.app.repository;

import com.veemart.app.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,String> {
    public List<ProductEntity> findByCatalogyName(String catalogName);
}
