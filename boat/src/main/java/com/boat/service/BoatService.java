/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.service;

import com.boat.model.Boat;
import com.boat.repository.BoatRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jquiroga
 */
@Service
public class BoatService {

    @Autowired
    private BoatRepo boatRepository;

    public List<Boat> getAll() {
        return boatRepository.getAll();
    }

    public Optional<Boat> getBoat(int id) {
        return boatRepository.getBoat(id);
    }

    public Boat save(Boat boats) {
        if (boats.getId() == null) {
            return boatRepository.save(boats);
        } else {
            Optional<Boat> evt = boatRepository.getBoat(boats.getId());
            if (evt.isEmpty()) {
                return boatRepository.save(boats);
            } else {
                return boats;
            }
        }
    }

}
