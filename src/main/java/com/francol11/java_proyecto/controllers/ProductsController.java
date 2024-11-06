package com.francol11.java_proyecto.controllers;

import com.francol11.java_proyecto.entity.Products;
import com.francol11.java_proyecto.services.ProductsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductsService service;

    public ProductsController(ProductsService service) {
        this.service = service;
    }
    @Operation(summary = "Get all Products",description = "Get all Products",tags = {"Products"},responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<Products>> getAll() {
        Iterable<Products> products = service.getProducts();
        return ResponseEntity.ok(products);
    }
    @Operation(summary = "Get Product by id",description = "Get Product by id",tags = {"Products"},responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<Products>> getById(@PathVariable Long id) {
        Optional<Products> product = service.getById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Create Product",description = "Create Product",tags = {"Products"},responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request",content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Products.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Products> create(@RequestBody Products product) {
        try {
            Products newProduct = service.save(product);
            return ResponseEntity.ok(newProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
