package com.francol11.java_proyecto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Invoice_Details")
@Getter @Setter @NoArgsConstructor
public class InvoiceDetails {

        public InvoiceDetails(Invoice invoice, int amount, Products product, double price) {
            this.invoice = invoice;
            this.amount = amount;
            this.product = product;
            this.price = price;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "invoice_detail_id")
        @Schema(description = "Id de la factura detallada", example = "1", requiredMode = Schema.RequiredMode.AUTO)
        private Long invoiceDetailId;

       @ManyToOne(fetch = FetchType.LAZY)
       @JoinColumn(name = "invoice_id", nullable = false)
       @Schema(description = "Id de la factura", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
       private Invoice invoice;

        @Column(name = "amount", nullable = false)
        @Schema(description = "Cantidad de productos", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
        private int amount;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id", nullable = false)
        @Schema(description = "Id del producto", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        private Products product;

        @Column(name = "price", nullable = false)
        @Schema(description = "Precio del producto", example = "10.00", requiredMode = Schema.RequiredMode.REQUIRED)
        private Double price;


    }
