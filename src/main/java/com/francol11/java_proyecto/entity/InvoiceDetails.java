package com.francol11.java_proyecto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Invoice_Details")
@Getter @Setter @NoArgsConstructor
public class InvoiceDetails {

        public InvoiceDetails(int invoiceId, int amount, int productId, double price) {
            this.invoiceId = invoiceId;
            this.amount = amount;
            this.productId = productId;
            this.price = price;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "invoice_detail_id")
        private Long invoiceDetailId;

        @Column(name = "invoice_id", nullable = false)
        private int invoiceId;

        @Column(name = "amount", nullable = false)
        private int amount;

        @Column(name = "product_id", nullable = false)
        private int productId;

        @Column(name = "price", nullable = false)
        private Double price;


    }
