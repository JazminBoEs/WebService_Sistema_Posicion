package com.sistema.raspberry.controller;

import com.sistema.raspberry.model.AprilTag;
import com.sistema.raspberry.model.Posicion;
import com.sistema.raspberry.model.Relacion;
import com.sistema.raspberry.repository.AprilTagRepository;
import com.sistema.raspberry.repository.PosicionRepository;
import com.sistema.raspberry.repository.RelacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posiciones")
@CrossOrigin(origins = "*")
public class PosicionController {

    private final PosicionRepository posicionRepository;
    private final AprilTagRepository aprilTagRepository;
    private final RelacionRepository relacionRepository;

    public PosicionController(
            PosicionRepository posicionRepository,
            AprilTagRepository aprilTagRepository,
            RelacionRepository relacionRepository) {
        this.posicionRepository = posicionRepository;
        this.aprilTagRepository = aprilTagRepository;
        this.relacionRepository = relacionRepository;
    }

    // GET: obtener todas las posiciones
    @GetMapping
    public List<Posicion> getAllPositions() {
        return posicionRepository.findAll();
    }

    // POST: crear nueva posición con relaciones a AprilTags
    @PostMapping
    public ResponseEntity<?> createPosition(@RequestBody Map<String, Object> payload) {
        try {
            // Extraer datos de la posición
            Double x = ((Number) payload.get("x")).doubleValue();
            Double y = ((Number) payload.get("y")).doubleValue();
            Double orientacion = ((Number) payload.get("orientacion")).doubleValue();
            String fechaStr = (String) payload.get("fecha");
            
            // Parsear fecha
            java.time.LocalDateTime fecha = java.time.LocalDateTime.parse(fechaStr);
            
            // Crear y guardar la posición
            Posicion posicion = new Posicion(x, y, orientacion, fecha);
            Posicion savedPosicion = posicionRepository.save(posicion);
            
            // Extraer IDs de AprilTags
            @SuppressWarnings("unchecked")
            List<Integer> aprilTagIds = (List<Integer>) payload.get("idAprilTag");
            
            // Crear relaciones
            if (aprilTagIds != null && !aprilTagIds.isEmpty()) {
                for (Integer tagId : aprilTagIds) {
                    AprilTag aprilTag = aprilTagRepository.findById(tagId.longValue())
                            .orElseThrow(() -> new RuntimeException("AprilTag " + tagId + " no encontrado"));
                    
                    Relacion relacion = new Relacion(savedPosicion, aprilTag);
                    relacionRepository.save(relacion);
                }
            }
            
            return ResponseEntity.ok(savedPosicion);
            
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al crear posición: " + e.getMessage());
        }
    }
}