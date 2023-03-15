package com.bosonit.formacion.block7crudvalidation.persona.controller.dto;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import org.mapstruct.Mapper;

@Mapper
public interface PersonaMapper {
    PersonaOutputDto personaToPersonaOutputDto(Persona persona);

    Persona personaOutputDtoToPersona (PersonaOutputDto personaOutputDto);

    PersonaInputDto personaToPersonaInputDto (Persona persona);

    Persona personaInputDtoToPersona (PersonaInputDto personaInputDto);
}
