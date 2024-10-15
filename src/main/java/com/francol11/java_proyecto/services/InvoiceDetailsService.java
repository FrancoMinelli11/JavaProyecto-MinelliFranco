package com.francol11.java_proyecto.services;

import com.francol11.java_proyecto.entity.InvoiceDetails;
import com.francol11.java_proyecto.repository.InvoiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailsService {

    @Autowired
    private InvoiceDetailRepository invoiceDetails;

    public InvoiceDetailsService(InvoiceDetailRepository invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public InvoiceDetails save(InvoiceDetails nInvoiceDetails) {
        return invoiceDetails.save(nInvoiceDetails);
    }

    public List<InvoiceDetails> getInvoiceDetails() {
        return invoiceDetails.findAll();
    }

    public Optional<InvoiceDetails> getById(Long id){
        return invoiceDetails.findById(id);
    }
}
