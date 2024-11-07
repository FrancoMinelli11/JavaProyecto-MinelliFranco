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

        public InvoiceDetails(int invoiceId, int amount, int productId, double price) {
            this.invoiceId = invoiceId;
            this.amount = amount;
            this.productId = productId;
            this.price = price;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "invoice_detail_id")
        @Schema(description = "Id de la factura detallada", example = "1", requiredMode = Schema.RequiredMode.AUTO)
        private Long invoiceDetailId;

        @Column(name = "invoice_id", nullable = false)
        @Schema(description = "Id de la factura", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        private int invoiceId;

        @Column(name = "amount", nullable = false)
        @Schema(description = "Cantidad de productos", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
        private int amount;

        @Column(name = "product_id", nullable = false)
        @Schema(description = "Id del producto", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
        private int productId;

        @Column(name = "price", nullable = false)
        @Schema(description = "Precio del producto", example = "10.00", requiredMode = Schema.RequiredMode.REQUIRED)
        private Double price;


    }
