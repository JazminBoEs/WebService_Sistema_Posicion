package com.sistema.raspberry.model;

import jakarta.persistence.*;

@Entity
@Table(name = "April_Tag")
public class AprilTag {

    @Id
    @Column(name = "id_AprilTag")
    private Long idAprilTag;

    private double x;
    private double y;
    private double orientacion;

    public Long getIdAprilTag() {
        return idAprilTag;
    }

    public void setIdAprilTag(Long idAprilTag) {
        this.idAprilTag = idAprilTag;
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
}
