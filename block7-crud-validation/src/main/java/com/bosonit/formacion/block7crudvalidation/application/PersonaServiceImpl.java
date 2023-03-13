package com.bosonit.formacion.block7crudvalidation.application;

import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaMapper;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.repository.PersonaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto){
        personaInputDto = validacion(personaInputDto);
        Persona persona = personaRepository.save(mapper.personaInputDtoToPersona(personaInputDto));
        return mapper.personaToPersonaOutputDto(persona);
    }

    @Override
    public PersonaOutputDto getPersonaById(int id) {
        Persona personaDevolver = personaRepository.findById(id).orElseThrow();
        return mapper.personaToPersonaOutputDto(personaDevolver);
    }

    @Override
    public List<PersonaOutputDto> getAllPersonas() {
        return personaRepository.findAll().stream()
                .map(p -> mapper.personaToPersonaOutputDto(p))
                .toList();
    }

    @Override
    public PersonaOutputDto getPersonaByUsername(String username) {
        Persona p = personaRepository.findByUsername(username).orElseThrow();
        return mapper.personaToPersonaOutputDto(p);
        /*return personaRepository.findAll().stream()
                .filter(p -> p.getUsername().equals(usuario))
                .map(p -> mapper.personaToPersonaOutputDto(p))
                .findFirst()
                .get();*/
    }

    private PersonaInputDto validacion(PersonaInputDto personaInputDto){
        if(personaInputDto.getUsername() == null || personaInputDto.getUsername().isEmpty()){
            throw new RuntimeException("Usuario no puede estar vacio");
        }
        if(personaInputDto.getUsername().length() < 6){
            throw new RuntimeException("Usuario no puede tener menos de 6");
        }
        if(personaInputDto.getUsername().length() > 10){
            throw new RuntimeException("Usuario no puede tener mas de 10");
        }
        if(personaInputDto.getPassword() == null || personaInputDto.getUsername().isEmpty()){
            throw new RuntimeException("Password no puede estar vacio");
        }
        if(personaInputDto.getName() == null || personaInputDto.getUsername().isEmpty()){
            throw new RuntimeException("Name no puede estar vacio");
        }
        if(personaInputDto.getCompany_email() == null || personaInputDto.getPersonal_email() == null
                || personaInputDto.getUsername().isEmpty() || personaInputDto.getUsername().isEmpty()){
            throw new RuntimeException("Email no puede estar vacio");
        }
        if(personaInputDto.getCity() == null || personaInputDto.getUsername().isEmpty()){
            throw new RuntimeException("City no puede estar vacio");
        }
        if(personaRepository.findByUsername(personaInputDto.getUsername()).isPresent()){
            throw new RuntimeException(("Ya existe el usuario"));
        }

        personaInputDto.setCreated_date(new Date());
        personaInputDto.setActive(true);

        return personaInputDto;
    }
}
