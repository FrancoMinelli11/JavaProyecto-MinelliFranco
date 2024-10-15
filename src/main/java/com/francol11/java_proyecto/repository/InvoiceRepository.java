package com.francol11.java_proyecto.repository;

import com.francol11.java_proyecto.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
