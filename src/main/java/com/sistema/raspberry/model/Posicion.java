package com.sistema.raspberry.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Posicion")
public class Posicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Posicion")
    private Long idPosicion;

    private double x;
    private double y;
    private double orientacion;

    private LocalDateTime fecha;

    @OneToMany(mappedBy = "posicion", cascade = CascadeType.ALL)
    private List<Relacion> relaciones = new ArrayList<>();

    // GETTERS Y SETTERS

    public Long getIdPosicion() {
        return idPosicion;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(double orientacion) {
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

    public void addRelacion(Relacion relacion) {
        relaciones.add(relacion);
        relacion.setPosicion(this);
    }
}
