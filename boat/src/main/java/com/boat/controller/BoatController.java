/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.controller;

import com.boat.model.Boat;
import com.boat.service.BoatService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jquiroga
 */
@RestController
@RequestMapping("/Boat")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class BoatController {
    @Autowired
    private BoatService boatService;
    
    @GetMapping("/all")
    public List<Boat> getBoats() {
        return boatService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Boat> getBoat(@PathVariable("id") int id) {
        return boatService.getBoat(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boats) {
        return boatService.save(boats);
    }    
    
}
