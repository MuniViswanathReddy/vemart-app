package com.veemart.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="catalog")
public class CatalogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="catalog_id")
    private int id;
    @Column(name="catalog_name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="tags")
    private String tags;
}
