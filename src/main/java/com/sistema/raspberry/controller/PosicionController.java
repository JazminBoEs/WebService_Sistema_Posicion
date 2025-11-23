package com.sistema.raspberry.controller;

import com.sistema.raspberry.model.Posicion;
import com.sistema.raspberry.repository.PosicionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posiciones")
@CrossOrigin(origins = "*")
public class PosicionController {

    private final PosicionRepository posicionRepository;

    public PosicionController(PosicionRepository posicionRepository) {
        this.posicionRepository = posicionRepository;
    }

    // GET: obtener todas
    @GetMapping
    public List<Posicion> getAllPositions() {
        return posicionRepository.findAll();
    }

    // POST: nueva posicion (la Raspberry mandará esto)
    @PostMapping
    public Posicion createPosition(@RequestBody Posicion posicion) {
        return posicionRepository.save(posicion);
    }
}
