package com.francol11.java_proyecto.services;

import com.francol11.java_proyecto.entity.Client;
import com.francol11.java_proyecto.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository client;

    public ClientService (ClientRepository client) {
        this.client = client;
    }

    public Client save(Client nClient){
        return client.save(nClient);
    }

    public List<Client> getClients() {
        return client.findAll();
    }

    public Optional<Client> getById(Long id) {
        return client.findById(id);
    }
}
