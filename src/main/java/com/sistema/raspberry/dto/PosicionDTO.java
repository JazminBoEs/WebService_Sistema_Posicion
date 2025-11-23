package com.sistema.raspberry.dto;

import com.sistema.raspberry.model.Posicion;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PosicionDTO {
    private Long idPosicion;
    private Double x;
    private Double y;
    private Double orientacion;
    private LocalDateTime fecha;
    private List<Long> idAprilTags; // Solo los IDs

    public PosicionDTO(Posicion posicion) {
        this.idPosicion = posicion.getIdPosicion();
        this.x = posicion.getX();
        this.y = posicion.getY();
        this.orientacion = posicion.getOrientacion();
        this.fecha = posicion.getFecha();
        
        // Extraer solo los IDs de los AprilTags
        if (posicion.getRelaciones() != null) {
            this.idAprilTags = posicion.getRelaciones().stream()
                .map(relacion -> relacion.getAprilTag().getIdAprilTag())
                .collect(Collectors.toList());
        }
    }

    // Getters
    public Long getIdPosicion() {
        return idPosicion;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getOrientacion() {
        return orientacion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public List<Long> getIdAprilTags() {
        return idAprilTags;
    }
}