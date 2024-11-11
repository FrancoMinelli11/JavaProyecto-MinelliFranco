package com.francol11.java_proyecto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Products")
@Getter @Setter @NoArgsConstructor
public class Products {

    public Products(String description, String code, Integer stock, Double price) {
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id del producto", example = "1", requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @Column(name = "description", nullable = false)
    @Schema(description = "Descripción del producto", example = "Producto de prueba", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @Column(name = "code", nullable = false)
    @Schema(description = "Código del producto", example = "PRD1", requiredMode = Schema.RequiredMode.REQUIRED)
    private String code;

    @Column(name = "stock", nullable = false)
    @Schema(description = "Stock", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer stock;

    @Column(name = "price", nullable = false)
    @Schema(description = "Precio", example = "10.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double price;

}
