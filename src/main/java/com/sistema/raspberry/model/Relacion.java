package com.sistema.raspberry.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "relacion")
public class Relacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_tag;

    private Double pos_x_robot;
    private Double pos_y_robot;
    private Double orientacion;

    private LocalDateTime fecha_hora;

    public Relacion() {}

    public Relacion(Long id_tag, Double pos_x_robot, Double pos_y_robot, Double orientacion, LocalDateTime fecha_hora) {
        this.id_tag = id_tag;
        this.pos_x_robot = pos_x_robot;
        this.pos_y_robot = pos_y_robot;
        this.orientacion = orientacion;
        this.fecha_hora = fecha_hora;
    }

    public Long getId() {
        return id;
    }

    public Long getId_tag() {
        return id_tag;
    }

    public void setId_tag(Long id_tag) {
        this.id_tag = id_tag;
    }

    public Double getPos_x_robot() {
        return pos_x_robot;
    }

    public void setPos_x_robot(Double pos_x_robot) {
        this.pos_x_robot = pos_x_robot;
    }

    public Double getPos_y_robot() {
        return pos_y_robot;
    }

    public void setPos_y_robot(Double pos_y_robot) {
        this.pos_y_robot = pos_y_robot;
    }

    public Double getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Double orientacion) {
        this.orientacion = orientacion;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
}
