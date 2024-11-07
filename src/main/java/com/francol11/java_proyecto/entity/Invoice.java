package com.francol11.java_proyecto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Invoice")
@Getter @Setter @NoArgsConstructor
public class Invoice {

    public Invoice(Long clientId, LocalDateTime createdAt, Double total) {
        this.clientId = clientId;
        this.createdAt = createdAt;
        this.total = total;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id de la factura", example = "1", requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    @Schema(description = "Fecha de creación de la factura", example = "2023-01-01T00:00:00", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime createdAt;

    @Column(name = "total", nullable = false)
    @Schema(description = "Total de la factura", example = "100.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double total;

}
