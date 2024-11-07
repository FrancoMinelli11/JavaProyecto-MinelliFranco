package com.francol11.java_proyecto.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Client")
@Getter @Setter @NoArgsConstructor
public class Client {

    public Client(String name, String lastname, Integer dni) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id del cliente", example = "1", requiredMode = Schema.RequiredMode.AUTO)
    private Long id;

    @Column(name = "name",nullable = false)
    @Schema(description = "Nombre del cliente", example = "Juan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Column(name = "lastname",nullable = false)
    @Schema(description = "Apellido del cliente", example = "Perez", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastname;

    @Column(name = "dni",nullable = false,unique = true)
    @Schema(description = "DNI del cliente", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer dni;

}
