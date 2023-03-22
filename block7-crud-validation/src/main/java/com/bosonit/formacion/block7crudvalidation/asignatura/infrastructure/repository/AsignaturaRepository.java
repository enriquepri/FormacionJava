package com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.repository;

import com.bosonit.formacion.block7crudvalidation.asignatura.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
    Optional<Asignatura> findByNombre(String nombre);
}
