/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jquiroga
 */
@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;
    @Column(nullable = false, length = 45)
    private String email;
    @Column(nullable = false, length = 45)
    private String password;  
    @Column(nullable = false, length = 250)
    private String name;
    @Column(nullable = false)
    private Integer age;

    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy= "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy= "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    
}
