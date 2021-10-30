/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.service;

import com.boat.model.Reservation;
import com.boat.model.custom.CountClient;
import com.boat.model.custom.StatusAmount;
import com.boat.repository.ReservationRepo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *Esta clase no provee las diferentes funcionalidades que usaremos por controller
 * @author jquiroga
 */
@Service
public class ReservationService {
/**
 *Nos trae los metodos para construir nuestros servicios
 * 
 */
    @Autowired
    private ReservationRepo reservationRepository;
/**
 *Nos lista todas las reservas que tiene nuestra app
 * 
 */
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationRepository.getAll();
    }
/**
 *Nos implementa el opcional
 * 
 */
    public Optional<Reservation> getReservation(int idReservation) {
        return reservationRepository.getReservation(idReservation);
    }
/**
 *Servicio para registrar una nueva reserva
 * 
 */

    public Reservation save(Reservation reservations) {
        if (reservations.getIdReservation() == null) {
            return reservationRepository.save(reservations);
        } else {
            Optional<Reservation> evt = reservationRepository.getReservation(reservations.getIdReservation());
            if (evt.isEmpty()) {
                return reservationRepository.save(reservations);
            } else {
                return reservations;
            }
        }
    }
/**
 *Servicio para borrar la reserva identificada con el id dado
 * 
 */
    public boolean deleteReservation(int id) {
        Optional<Reservation> reservation = reservationRepository.getReservation(id);
        if (reservation.isEmpty()) {
            return false;
        } else {
            reservationRepository.delete(reservation.get());
            return true;
        }
    }
/**
 *Servicio para actualizar las reservas
 *
 */
    public Reservation updateReservation(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reserva = reservationRepository.getReservation(reservation.getIdReservation());

            if (!reserva.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    reserva.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reserva.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reserva.get().setStatus(reservation.getStatus());
                }

                return reservationRepository.save(reserva.get());
            } else {
                return reservation;
            }
        }
        return reservation;
    }
        
    public List<Reservation> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }

    }
    
    public StatusAmount getReservationsStatusReport(){
        List<Reservation>completed=reservationRepository.getReservationsByStatus("completed");
        List<Reservation>cancelled=reservationRepository.getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());
    }
    
    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

}
