package com.sistema.raspberry.controller;

import com.sistema.raspberry.model.Relacion;
import com.sistema.raspberry.repository.RelacionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relaciones")
@CrossOrigin(origins = "*")
public class RelacionController {

    private final RelacionRepository relacionRepository;

    public RelacionController(RelacionRepository relacionRepository) {
        this.relacionRepository = relacionRepository;
    }

    // GET: obtener todas
    @GetMapping
    public List<Relacion> getAllRelations() {
        return relacionRepository.findAll();
    }

    // POST: registrar qué apriltag está viendo la Raspberry
    @PostMapping
    public Relacion createRelation(@RequestBody Relacion relacion) {
        return relacionRepository.save(relacion);
    }
}
