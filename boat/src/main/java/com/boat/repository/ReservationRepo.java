/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.repository;

import com.boat.model.Client;
import com.boat.model.Reservation;
import com.boat.model.custom.CountClient;
import java.util.ArrayList;
import java.util.Date;
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
        public List<Reservation> getReservationPeriod(Date a, Date b){
        return crud.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    
     public List<Reservation> getReservationsByStatus(String status){
        return crud.findAllByStatus(status);
    }
     
    public  List<CountClient> getTopClients(){
        List<CountClient>res=new ArrayList<>();
        List<Object[]>report=crud.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    } 

}
