package com.veemart.app.repository;

import com.veemart.app.entity.CatalogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<CatalogEntity, Integer> {
    public CatalogEntity findByName(String name);
}

