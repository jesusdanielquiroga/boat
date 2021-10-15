/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author jquiroga
 */
@Entity
@Table(name = "reservation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {
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
    @JoinColumn(name = "boatId")  
    @JsonIgnoreProperties("reservations")
    private Boat boat;
    
    @ManyToOne
    @JoinColumn(name = "clientId")  
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

                
    @OneToMany(cascade = {CascadeType.REMOVE},mappedBy= "reservation")
    @JsonIgnoreProperties("reservation")
    private List<Score> score;

}
