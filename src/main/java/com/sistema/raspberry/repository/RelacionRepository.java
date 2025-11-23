package com.sistema.raspberry.repository;

import com.sistema.raspberry.model.Relacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacionRepository extends JpaRepository<Relacion, Long> {
}
