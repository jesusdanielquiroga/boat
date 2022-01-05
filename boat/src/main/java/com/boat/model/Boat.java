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
 * Esta clase representa a la entidad boat
 *
 * @author jquiroga
 */
@Entity
@Table(name = "boat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Identificador boat
     */
    private Integer id;
    /**
     * Nombre de boat
     */
    private String name;
    /**
     * Marca del boat
     */
    @Column(nullable = false, length = 45)
    private String brand;
    /**
     * modelo (year) boat
     */
    @Column(nullable = false)
    private Integer year;
    /**
     * Breve descripción de boat
     */
    @Column(nullable = false, length = 250)
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("boats")
    /**
     * Categoria a la que pertenece el boat
     */
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "client"})
    /**
     * Mensajes asociados al boat
     */
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties({"boat", "messages"})
    /**
     * Reservas relacionadas al boat
     */
    private List<Reservation> reservations;

}
