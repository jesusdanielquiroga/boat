/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.repository;

import com.boat.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jquiroga
 */
@Repository
public class ClientRepo {
    @Autowired
    private ClientRepository crud;
    
    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }
    public Optional <Client> getClient(int idClient){
        return crud.findById(idClient);
    }
    public Client save(Client clients){
        return crud.save(clients);
    }

    
}
