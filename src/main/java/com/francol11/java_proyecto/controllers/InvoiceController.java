package com.francol11.java_proyecto.controllers;


import com.francol11.java_proyecto.entity.Invoice;
import com.francol11.java_proyecto.services.InvoiceService;
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
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }
    @Operation(summary = "Get all invoices",description = "Get all invoices",tags = {"Invoices"},responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<Invoice>> getAll() {
        Iterable<Invoice> invoices = service.getInvoices();
        return ResponseEntity.ok(invoices);
    }
    @Operation(summary = "Get invoice by id",description = "Get invoice by id",tags = {"Invoices"},responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<Invoice>> getById(@PathVariable Long id) {
        Optional<Invoice> invoice = service.getById(id);

        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Create invoice",description = "Create invoice",tags = {"Invoices"},responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {@Content(mediaType="application/json", schema = @Schema(implementation = Invoice.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) {
        try {
            Invoice newInvoice = service.save(invoice);
            return ResponseEntity.ok(newInvoice);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}

