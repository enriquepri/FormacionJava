package com.bosonit.formacion.block7crudvalidation.application;

import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaMapper;
import com.bosonit.formacion.block7crudvalidation.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
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
        Persona personaDevolver = personaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No existe persona con la id " + id)
        );
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
        Persona p = personaRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("No existe persona con el usuario " + username)
        );
        return mapper.personaToPersonaOutputDto(p);
        /*return personaRepository.findAll().stream()
                .filter(p -> p.getUsername().equals(usuario))
                .map(p -> mapper.personaToPersonaOutputDto(p))
                .findFirst()
                .get();*/
    }

    @Override
    public void deletePersonaById(int id) {
        personaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No hay persona con Id: " + id)
        );
        personaRepository.deleteById(id);
    }

    @Override
    public void deletePersonaByUsername(String username) {
        Persona p = personaRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("No hay persona con Username: " + username)
        );
        //personaRepository.deleteByUsername(username);
        personaRepository.delete(p);
    }

    private PersonaInputDto validacion(PersonaInputDto personaInputDto){
        if(personaInputDto.getUsername() == null || personaInputDto.getUsername().isEmpty()){
            throw new UnprocessableEntityException("Usuario no puede estar vacio");
        }
        if(personaInputDto.getUsername().length() < 6){
            throw new UnprocessableEntityException("Usuario no puede tener menos de 6 caracteres");
        }
        if(personaInputDto.getUsername().length() > 10){
            throw new UnprocessableEntityException("Usuario no puede tener mas de 10 caracteres");
        }
        if(personaInputDto.getPassword() == null || personaInputDto.getUsername().isEmpty()){
            throw new UnprocessableEntityException("Password no puede estar vacio");
        }
        if(personaInputDto.getName() == null || personaInputDto.getUsername().isEmpty()){
            throw new UnprocessableEntityException("Name no puede estar vacio");
        }
        if(personaInputDto.getCompany_email() == null || personaInputDto.getPersonal_email() == null
                || personaInputDto.getUsername().isEmpty() || personaInputDto.getUsername().isEmpty()){
            throw new UnprocessableEntityException("Email no puede estar vacio");
        }
        if(personaInputDto.getCity() == null || personaInputDto.getUsername().isEmpty()){
            throw new UnprocessableEntityException("City no puede estar vacio");
        }
        if(personaRepository.findByUsername(personaInputDto.getUsername()).isPresent()){
            throw new UnprocessableEntityException(
                    ("Ya existe una persona con usuario: " + personaInputDto.getUsername()));
        }

        personaInputDto.setCreated_date(new Date());
        personaInputDto.setActive(true);

        return personaInputDto;
    }
}
