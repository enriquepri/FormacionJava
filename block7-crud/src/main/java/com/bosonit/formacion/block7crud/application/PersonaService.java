package com.bosonit.formacion.block7crud.application;

import com.bosonit.formacion.block7crud.domain.Persona;

public interface PersonaService {
    Persona addPersona(Persona p);
    Persona updatePersona(Persona p);
    void deletePersonaById(int id);
    Persona getPersonaById(int id);
    Iterable<Persona> getAllByName(String nombre);
    Iterable<Persona> getAll();
}
