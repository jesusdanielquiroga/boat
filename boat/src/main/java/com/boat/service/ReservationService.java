/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.service;

import com.boat.model.Reservation;
import com.boat.repository.ReservationRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jquiroga
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int idReservation) {
        return reservationRepository.getReservation(idReservation);
    }

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

    public boolean deleteReservation(int id) {
        Optional<Reservation> reservation = reservationRepository.getReservation(id);
        if (reservation.isEmpty()) {
            return false;
        } else {
            reservationRepository.delete(reservation.get());
            return true;
        }
    }

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

}
