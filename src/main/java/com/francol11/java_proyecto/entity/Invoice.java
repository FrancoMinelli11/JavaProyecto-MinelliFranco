package com.francol11.java_proyecto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Invoice")
@Getter @Setter @NoArgsConstructor
public class Invoice {

    public Invoice(Client client, LocalDateTime createdAt, Double total) {
        this.client = client;
        this.createdAt = createdAt;
        this.total = total;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id de la factura", example = "1", requiredMode = Schema.RequiredMode.AUTO)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @Schema(description = "Id del cliente", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Client client;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    @Schema(description = "Fecha de creación de la factura", example = "2023-01-01T00:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createdAt;

    @Column(name = "total", nullable = false)
    @Schema(description = "Total de la factura", example = "100.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double total;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "Lista de facturas detalladas", example = "[1,2,3]", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<InvoiceDetails> invoiceDetails;

}
