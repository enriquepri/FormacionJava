package com.bosonit.formacion.block7crudvalidation.application;

import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;

public interface PersonaService {
    PersonaOutputDto addPersona (PersonaInputDto persona);
    Iterable<PersonaOutputDto> getAllPersonas();
    PersonaOutputDto getPersonaById (int id);
    PersonaOutputDto getPersonaByUsername (String username);
    void deletePersonaById(int id);
    void deletePersonaByUsername(String username);
}
