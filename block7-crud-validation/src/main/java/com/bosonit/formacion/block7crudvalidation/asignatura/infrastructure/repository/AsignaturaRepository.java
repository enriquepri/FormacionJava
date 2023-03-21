package com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.repository;

import com.bosonit.formacion.block7crudvalidation.asignatura.domain.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer> {
}
