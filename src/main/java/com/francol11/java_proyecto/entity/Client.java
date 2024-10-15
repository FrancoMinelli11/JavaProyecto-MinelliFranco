package com.francol11.java_proyecto.entity;

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
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "lastname",nullable = false)
    private String lastname;

    @Column(name = "dni",nullable = false,unique = true)
    private Integer dni;

}
