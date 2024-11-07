package com.francol11.java_proyecto.controllers;

import com.francol11.java_proyecto.entity.InvoiceDetails;
import com.francol11.java_proyecto.services.InvoiceDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Get all InvoiceDetails", tags = {"Invoice-Details"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<InvoiceDetails>> getAll() {
        Iterable<InvoiceDetails> invoiceDts = service.getInvoiceDetails();
        return ResponseEntity.ok(invoiceDts);
    }
    @Operation(summary = "Get InvoiceDetail by id", tags = {"Invoice-Details"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<InvoiceDetails>> getById(@PathVariable Long invoiceDetailId) {
        Optional<InvoiceDetails> invoiceDts = service.getById(invoiceDetailId);

        if (invoiceDts.isPresent()) {
            return ResponseEntity.ok(invoiceDts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Create InvoiceDetail", tags = {"Invoice-Details"})
    @ApiResponses(value = {
         @ApiResponse(responseCode = "200", description = "Ok"),
         @ApiResponse(responseCode = "400", description = "Bad Request",
         content = {@Content(mediaType = "application/json", schema = @Schema(implementation = InvoiceDetails.class))}
         ),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
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

