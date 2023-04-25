package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.repository;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaOutputDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByUsername(String username);
    public List<PersonaOutputDto> getPersonalizado(HashMap<String, Object> conditions);
}
