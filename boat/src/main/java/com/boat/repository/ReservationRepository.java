/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.repository;


import com.boat.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jquiroga
 */
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo );
   
   
   public List<Reservation> findAllByStatus(String status);
   
    //SELECT count(*),`client_id` FROM `reservation` group by `client_id` order by count(*) desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    
}
