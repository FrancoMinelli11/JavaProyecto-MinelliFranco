package com.francol11.java_proyecto.controllers;


import com.francol11.java_proyecto.entity.Invoice;
import com.francol11.java_proyecto.entity.InvoiceDetails;
import com.francol11.java_proyecto.services.InvoiceDetailsService;
import com.francol11.java_proyecto.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/invoiceDetails")
public class InvoiceDetailsController {

    @Autowired
    private InvoiceDetailsService service;

    public InvoiceDetailsController(InvoiceDetailsService service) {
        this.service = service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<InvoiceDetails>> getAll() {
        Iterable<InvoiceDetails> invoiceDts = service.getInvoiceDetails();
        return ResponseEntity.ok(invoiceDts);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<InvoiceDetails>> getById(@PathVariable Long invoiceDetailId) {
        Optional<InvoiceDetails> invoiceDts = service.getById(invoiceDetailId);

        if (invoiceDts.isPresent()) {
            return ResponseEntity.ok(invoiceDts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<InvoiceDetails> create(@RequestBody InvoiceDetails invoiceDts) {
        try {
            InvoiceDetails newInvoiceDts = service.save(invoiceDts);
            return ResponseEntity.ok(newInvoiceDts);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}

