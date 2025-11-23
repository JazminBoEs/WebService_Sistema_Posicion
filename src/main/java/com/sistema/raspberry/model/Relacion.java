package com.sistema.raspberry.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Relacion")
public class Relacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Relacion")
    private Long idRelacion;

    @ManyToOne
    @JoinColumn(name = "id_Posicion", nullable = false)
    private Posicion posicion;

    @ManyToOne
    @JoinColumn(name = "id_AprilTag", nullable = false)
    private AprilTag aprilTag;

    @Column(name = "id_tag")
    private int idTagDetectado;  // El id_tag que detecta la cámara (desde PhotonVision)

    // GETTERS Y SETTERS

    public Long getIdRelacion() {
        return idRelacion;
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

    public int getIdTagDetectado() {
        retur
