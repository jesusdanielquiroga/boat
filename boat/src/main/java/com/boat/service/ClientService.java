/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.service;

import com.boat.model.Client;
import com.boat.repository.ClientRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jquiroga
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepo clientRepository;

    public List<Client> getAll() {
        return (List<Client>) clientRepository.getAll();
    }

    public Optional<Client> getClient(int idClient) {
        return clientRepository.getClient(idClient);
    }

    public Client save(Client clients) {
        if (clients.getIdClient() == null) {
            return clientRepository.save(clients);
        } else {
            Optional<Client> evt = clientRepository.getClient(clients.getIdClient());
            if (evt.isEmpty()) {
                return clientRepository.save(clients);
            } else {
                return clients;
            }
        }
    }

    public boolean deleteClient(int id) {
        Optional<Client> client = clientRepository.getClient(id);
        if (client.isEmpty()) {
            return false;
        } else {
            clientRepository.delete(client.get());
            return true;
        }
    }

    public Client updateClient(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> cliente = clientRepository.getClient(client.getIdClient());

            if (!cliente.isEmpty()) {
                if (client.getName() != null) {
                    cliente.get().setName(client.getName());
                }

                if (client.getEmail() != null) {
                    cliente.get().setEmail(client.getEmail());
                }

                if (client.getPassword() != null) {
                    cliente.get().setPassword(client.getPassword());
                }

                if (client.getAge() != null) {
                    cliente.get().setAge(client.getAge());
                }

                return clientRepository.save(cliente.get());
            } else {
                return client;
            }
        }
        return client;
    }

}
