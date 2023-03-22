package com.bosonit.formacion.block7crudvalidation.persona.application;

import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaMapper;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.exception.EntityNotFoundException;
import com.bosonit.formacion.block7crudvalidation.exception.UnprocessableEntityException;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.repository.PersonaRepository;
import com.bosonit.formacion.block7crudvalidation.profesor.domain.Profesor;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.repository.ProfesorRepository;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.repository.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ProfesorRepository profesorRepository;

    //PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);

    @Override
    public PersonaOutputDto addPersona(PersonaInputDto personaInputDto) {
        if (personaRepository.findByUsername(personaInputDto.getUsername()).isPresent()) {
            throw new UnprocessableEntityException(
                    ("Ya existe una persona con usuario: " + personaInputDto.getUsername()));
        }
        personaInputDto = validacion(personaInputDto);
        Persona persona = personaRepository.save(new Persona(personaInputDto));
        return persona.personaToPersonaOutputDto();
    }

    @Override
    public PersonaOutputDto getPersonaById(int id, String outputType) {
        Persona personaDevolver = personaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No existe persona con la id " + id)
        );

        if (outputType.equals("simple")) return personaDevolver.personaToPersonaOutputDto();

        if (outputType.equals("full")) {
            if (personaDevolver.getStudent() != null) return personaDevolver.personaToPersonaStudentOutputDto();
            if (personaDevolver.getProfesor() != null) return personaDevolver.personaToPersonaProfesorOutputDto();
            return personaDevolver.personaToPersonaOutputDto();
        }

        throw new UnprocessableEntityException("Las opciones son simple o full");
    }

    @Override
    public List<PersonaOutputDto> getAllPersonas() {
        return personaRepository.findAll().stream()
                .map(Persona::personaToPersonaOutputDto)
                .toList();
    }

    @Override
    public PersonaOutputDto getPersonaByUsername(String username, String outputType) {
        Persona p = personaRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("No existe persona con el usuario " + username)
        );

        if (outputType.equals("simple")) return p.personaToPersonaOutputDto();

        if (outputType.equals("full")) {
            if (p.getStudent() != null) return p.personaToPersonaStudentOutputDto();
            if (p.getProfesor() != null) return p.personaToPersonaProfesorOutputDto();
            return p.personaToPersonaOutputDto();
        }

        throw new UnprocessableEntityException("Las opciones son simple o full");

        /*return personaRepository.findAll().stream()
                .filter(p -> p.getUsername().equals(usuario))
                .map(p -> mapper.personaToPersonaOutputDto(p))
                .findFirst()
                .get();*/
    }

    @Override
    public void deletePersonaById(int id) {
        Persona persona = personaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No hay persona con Id: " + id)
        );

        eliminarRelacionesPersona(persona);

        personaRepository.deleteById(id);
    }

    @Override
    public void deletePersonaByUsername(String username) {
        Persona persona = personaRepository.findByUsername(username).orElseThrow(
                () -> new EntityNotFoundException("No hay persona con Username: " + username)
        );

        eliminarRelacionesPersona(persona);

        personaRepository.delete(persona);
    }

    @Override
    public PersonaOutputDto updatePersona(PersonaInputDto personaInputDto) {
        int id = personaInputDto.getId_persona();
        Persona p = personaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No se ha encontrado a la persona con Id: " + id)
        );

        if (!personaInputDto.getUsername().equals(p.getUsername()) &&
                personaRepository.findByUsername(personaInputDto.getUsername()).isPresent()) {
            throw new UnprocessableEntityException("Ya existe un usuario con ese usuario");
        }

        Persona person = new Persona(validacion(personaInputDto));

        person.setId_persona(p.getId_persona());
        return personaRepository.save(person).personaToPersonaOutputDto();
    }

    private PersonaInputDto validacion(PersonaInputDto personaInputDto) {
        if (personaInputDto.getUsername() == null || personaInputDto.getUsername().isEmpty()) {
            throw new UnprocessableEntityException("Usuario no puede estar vacio");
        }
        if (personaInputDto.getUsername().length() < 6) {
            throw new UnprocessableEntityException("Usuario no puede tener menos de 6 caracteres");
        }
        if (personaInputDto.getUsername().length() > 10) {
            throw new UnprocessableEntityException("Usuario no puede tener mas de 10 caracteres");
        }
        if (personaInputDto.getPassword() == null || personaInputDto.getPassword().isEmpty()) {
            throw new UnprocessableEntityException("Password no puede estar vacio");
        }
        if (personaInputDto.getName() == null || personaInputDto.getName().isEmpty()) {
            throw new UnprocessableEntityException("Name no puede estar vacio");
        }
        if (personaInputDto.getCompany_email() == null || personaInputDto.getPersonal_email() == null
                || personaInputDto.getCompany_email().isEmpty() || personaInputDto.getPersonal_email().isEmpty()) {
            throw new UnprocessableEntityException("Email no puede estar vacio");
        }
        if (personaInputDto.getCity() == null || personaInputDto.getCity().isEmpty()) {
            throw new UnprocessableEntityException("City no puede estar vacio");
        }

        personaInputDto.setCreated_date(new Date());
        personaInputDto.setActive(true);

        return personaInputDto;
    }

    private void eliminarRelacionesPersona(Persona persona){
        if(persona.getStudent() != null){
            Student student = persona.getStudent();
            studentRepository.delete(student);
        }
        if(persona.getProfesor() != null){
            Profesor profesor = persona.getProfesor();
            for(Student s : profesor.getStudents()){
                s.setProfesor(null);
                studentRepository.save(s);
            }
            profesorRepository.delete(profesor);
        }
    }
}
