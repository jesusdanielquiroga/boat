/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.repository;

import com.boat.model.Admin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jquiroga
 */
@Repository
public class AdminRepo {
    @Autowired
    private AdminRepository crud;
    
    public List<Admin> getAll(){
        return (List<Admin>) crud.findAll();
    }
    public Optional <Admin> getAdmin(int idAdmin){
        return crud.findById(idAdmin);
    }
    public Admin save(Admin admins){
        return crud.save(admins);
    }

    
}
