package com.francol11.java_proyecto.controllers;


import com.francol11.java_proyecto.entity.Invoice;
import com.francol11.java_proyecto.services.InvoiceService;
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

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<Invoice>> getAll() {
        Iterable<Invoice> invoices = service.getInvoices();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<Invoice>> getById(@PathVariable Long id) {
        Optional<Invoice> invoice = service.getById(id);

        if (invoice.isPresent()) {
            return ResponseEntity.ok(invoice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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

