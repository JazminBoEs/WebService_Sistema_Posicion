package com.sistema.raspberry.model;

import jakarta.persistence.*;

@Entity
public class Relacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // ejemplo: "cerca", "lejos", etc.
    private double distancia;

    // Muchas relaciones pertenecen a una Posicion
    @ManyToOne
    @JoinColumn(name = "posicion_id")
    private Posicion posicion;

    public Relacion() {}

    public Relacion(String tipo, double distancia, Posicion posicion) {
        this.tipo = tipo;
        this.distancia = distancia;
        this.posicion = posicion;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
}
