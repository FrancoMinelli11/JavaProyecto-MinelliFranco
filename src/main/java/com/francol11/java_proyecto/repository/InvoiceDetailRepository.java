package com.francol11.java_proyecto.repository;

import com.francol11.java_proyecto.entity.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetails, Long> {
}
