package com.sistema.raspberry.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Relacion")
public class Relacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muchas relaciones pertenecen a una Posicion
    @ManyToOne
    @JsonProperty("id_Posicion")
    @JoinColumn(name = "id_Posicion")
    private Posicion posicion;

    // Muchas relaciones pueden tener el mismo AprilTag
    @ManyToOne
    @JsonProperty("id_AprilTag")
    @JoinColumn(name = "id_AprilTag")
    private AprilTag aprilTag;

    // Constructores
    public Relacion() {}

    public Relacion(Posicion posicion, AprilTag aprilTag) {
        this.posicion = posicion;
        this.aprilTag = aprilTag;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public AprilTag getAprilTag() {
        return aprilTag;
    }

    public void setAprilTag(AprilTag aprilTag) {
        this.aprilTag = aprilTag;
    }
}