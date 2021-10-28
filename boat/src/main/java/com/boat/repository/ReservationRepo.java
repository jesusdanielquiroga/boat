/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.repository;

import com.boat.model.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jquiroga
 */
@Repository
public class ReservationRepo {

    @Autowired
    private ReservationRepository crud;

    public List<Reservation> getAll() {
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getReservation(int idReservation) {
        return crud.findById(idReservation);
    }

    public Reservation save(Reservation reservations) {
        return crud.save(reservations);
    }

    public void delete(Reservation reservation) {
        crud.delete(reservation);
    }

}
