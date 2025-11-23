package com.sistema.raspberry.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Posicion")
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_Posicion")
    @Column(name = "id_Posicion")
    private Long idPosicion;

    private Double x;
    private Double y;
    private Double orientacion;
    private LocalDateTime fecha;

    // Relación bidireccional con Relacion
    @OneToMany(mappedBy = "posicion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Relacion> relaciones;

    // Constructores
    public Posicion() {}

    public Posicion(Double x, Double y, Double orientacion, LocalDateTime fecha) {
        this.x = x;
        this.y = y;
        this.orientacion = orientacion;
        this.fecha = fecha;
    }

    // Getters y Setters
    public Long getIdPosicion() {
        return idPosicion;
    }

    public void setIdPosicion(Long idPosicion) {
        this.idPosicion = idPosicion;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Double orientacion) {
        this.orientacion = orientacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public List<Relacion> getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(List<Relacion> relaciones) {
        this.relaciones = relaciones;
    }
}