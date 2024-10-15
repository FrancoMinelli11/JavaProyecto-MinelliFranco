package com.francol11.java_proyecto.services;

import com.francol11.java_proyecto.entity.Invoice;
import com.francol11.java_proyecto.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoice;

    public InvoiceService(InvoiceRepository invoice) {
        this.invoice = invoice;
    }

    public Invoice save (Invoice nInvoice) {
        return invoice.save(nInvoice);
    }

    public List<Invoice> getInvoices () {
        return invoice.findAll();
    }

    public Optional<Invoice> getById(Long id) {
        return invoice.findById(id);
    }

}
