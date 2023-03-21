package com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.repository;

import com.bosonit.formacion.block7crudvalidation.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
}
