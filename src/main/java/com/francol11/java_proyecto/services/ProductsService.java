package com.francol11.java_proyecto.services;

import com.francol11.java_proyecto.entity.Products;
import com.francol11.java_proyecto.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository products;

    public ProductsService (ProductsRepository products) {
        this.products = products;
    }

    public Products save(Products nProducts) {
        return products.save(nProducts);
    }

    public List<Products> getProducts(){
        return products.findAll();
    }

    public Optional<Products> getById(Long id) {
        return products.findById(id);
    }

}
