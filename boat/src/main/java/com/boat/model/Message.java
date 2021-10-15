/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.boat.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jquiroga
 */
@Entity
@Table(name = "message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    @Column(nullable = false, length = 255)
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "boatId")  
    @JsonIgnoreProperties({"messages","reservations"})
    private Boat boat;
    
    @ManyToOne
    @JoinColumn(name = "clientId")  
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    
    
}
