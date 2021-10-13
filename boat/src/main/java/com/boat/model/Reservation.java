/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author jquiroga
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    @Column(nullable = false)
    private Date devolutionDate;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false, length = 255)
    private String status = "Created"; 
    
    @ManyToOne
    @JoinColumn(name = "Id")  
    @JsonIgnoreProperties("reservations")
    private Boat boat;
    
    @ManyToOne
    @JoinColumn(name = "IdClient")  
    @JsonIgnoreProperties("reservations")
    private Client client;

                
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy= "reservation")
    @JsonIgnoreProperties("reservation")
    private List<Score> score;

}
