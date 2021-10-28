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

    public boolean deleteBoat(int id) {
        Optional<Boat> boat = boatRepository.getBoat(id);
        if (boat.isEmpty()) {
            return false;
        } else {
            boatRepository.delete(boat.get());
            return true;
        }
    }
    public Boat updateBoat(Boat boat){
        if (boat.getId()!=null){
            Optional<Boat> bote = boatRepository.getBoat(boat.getId());
            
            if (!bote.isEmpty()){
               if (boat.getName()!=null){
                   bote.get().setName(boat.getName());
               }
               if (boat.getDescription()!=null){
                   bote.get().setDescription(boat.getDescription());
               }
               if (boat.getBrand()!=null){
                   bote.get().setBrand(boat.getBrand());
               }
               if (boat.getYear()!=null){
                   bote.get().setYear(boat.getYear());
               }
               return boatRepository.save(bote.get());
            }else{
               return boat;
            }
        }
        return boat;     
    }

}
