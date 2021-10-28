/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.repository;

import com.boat.model.Boat;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jquiroga
 */
@Repository
public class BoatRepo {

    @Autowired
    private BoatRepository crud;

    public List<Boat> getAll() {
        return (List<Boat>) crud.findAll();
    }

    public Optional<Boat> getBoat(int id) {
        return crud.findById(id);
    }

    public Boat save(Boat boats) {
        return crud.save(boats);
    }

    public void delete(Boat boat) {
        crud.delete(boat);
    }

}
