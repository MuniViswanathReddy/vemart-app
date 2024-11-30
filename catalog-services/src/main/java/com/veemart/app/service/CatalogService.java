package com.veemart.app.service;

import com.veemart.app.dto.CatalogDto;
import com.veemart.app.entity.CatalogEntity;
import com.veemart.app.entity.ProductEntity;
import com.veemart.app.repository.CatalogRepository;
import com.veemart.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    CatalogRepository catalogRepository;
    @Autowired
    ProductRepository productRepository;

    @Transactional
    public String createCatalog(CatalogDto catalogDto) {
        CatalogEntity catalogEntity = new CatalogEntity();
        catalogEntity.setId(catalogDto.getId());
        catalogEntity.setName(catalogDto.getName());
        catalogEntity.setDescription(catalogDto.getDescription());
        catalogEntity.setTags(catalogDto.getTags());
        catalogRepository.save(catalogEntity);
        return "Catalog created successfully";
    }

    @Transactional
    public String deleteCatalog(String catalogName) {
        CatalogEntity catalogEntity = catalogRepository.findByName(catalogName);
        catalogRepository.deleteById(catalogEntity.getId());
        List<ProductEntity> productEntityList = productRepository.findByCatalogyName(catalogName);

        for (ProductEntity productEntity : productEntityList) {
            productRepository.deleteById(productEntity.getName());
        }
        return "Catalog deleted successfully";
    }

    @Transactional
    public CatalogDto getCatalog(String catalogName) {
        CatalogEntity catalogEntity = catalogRepository.findByName(catalogName);
        CatalogDto catalogDto = new CatalogDto();
        catalogDto.setId(catalogEntity.getId());
        catalogDto.setName(catalogEntity.getName());
        catalogDto.setDescription(catalogEntity.getDescription());
        catalogDto.setTags(catalogEntity.getTags());
        return catalogDto;
    }

}

