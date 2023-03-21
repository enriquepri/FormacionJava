package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.repository;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByUsername(String username);
    long deleteByUsername(String username);
}
