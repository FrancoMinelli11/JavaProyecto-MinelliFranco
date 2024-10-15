package com.francol11.java_proyecto.entity;

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
    private Long id;

    @Column(name = "client_id")
    private Long clientId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "total", nullable = false)
    private Double total;

}
