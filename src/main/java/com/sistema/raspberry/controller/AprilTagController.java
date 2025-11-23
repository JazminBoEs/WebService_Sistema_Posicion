package com.sistema.raspberry.controller;

import com.sistema.raspberry.model.AprilTag;
import com.sistema.raspberry.repository.AprilTagRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apriltags")
@CrossOrigin(origins = "*")
public class AprilTagController {

    private final AprilTagRepository aprilTagRepository;

    public AprilTagController(AprilTagRepository aprilTagRepository) {
        this.aprilTagRepository = aprilTagRepository;
    }

    // GET: obtener todos
    @GetMapping
    public List<AprilTag> getAllAprilTags() {
        return aprilTagRepository.findAll();
    }

    // POST: insertar uno nuevo
    @PostMapping
    public AprilTag createAprilTag(@RequestBody AprilTag aprilTag) {
        return aprilTagRepository.save(aprilTag);
    }
}
