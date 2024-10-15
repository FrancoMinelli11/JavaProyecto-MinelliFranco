package com.francol11.java_proyecto.repository;

import com.francol11.java_proyecto.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
