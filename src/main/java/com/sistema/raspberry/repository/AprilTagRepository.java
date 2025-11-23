package com.sistema.raspberry.repository;

import com.sistema.raspberry.model.AprilTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AprilTagRepository extends JpaRepository<AprilTag, Long> {
}
