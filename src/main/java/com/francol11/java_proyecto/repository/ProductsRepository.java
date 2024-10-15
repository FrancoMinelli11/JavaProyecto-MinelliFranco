package com.francol11.java_proyecto.repository;

import com.francol11.java_proyecto.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long> {



}
