/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String brand;
    @Column(nullable = false)
    private Integer year;
    
    @ManyToOne
    @JoinColumn(name = "categoryId")  
    @JsonIgnoreProperties("boats")
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy= "boat")
    @JsonIgnoreProperties("boat")
    private List<Reservation> reservations;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy= "boat")
    @JsonIgnoreProperties({"boat", "client")
    private List<Message> messages;
    
    private String name;
    @Column(nullable = false, length = 250)
    private String description;
    
}
