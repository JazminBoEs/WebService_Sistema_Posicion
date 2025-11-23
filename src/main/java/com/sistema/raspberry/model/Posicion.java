package com.sistema.raspberry.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitud;
    private double longitud;
    private String descripcion;

    // Relación bidireccional (una posicion - muchas relaciones)
    @OneToMany(mappedBy = "posicion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relacion> relaciones;

    public Posicion() {}

    public Posicion(double latitud, double longitud, String descripcion) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Relacion> getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(List<Relacion> relaciones) {
        this.relaciones = relaciones;
    }
}
