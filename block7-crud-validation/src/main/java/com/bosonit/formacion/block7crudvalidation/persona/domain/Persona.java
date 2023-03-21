package com.bosonit.formacion.block7crudvalidation.persona.domain;

import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaInputDto;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.profesor.domain.Profesor;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    @GeneratedValue
    Integer id_persona;
    String username;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;

    @OneToOne(mappedBy = "persona")
    Student student;
    @OneToOne(mappedBy = "persona")
    Profesor profesor;

    public Persona(PersonaInputDto personaInputDto) {
        this.id_persona = personaInputDto.getId_persona();
        this.username = personaInputDto.getUsername();
        this.password = personaInputDto.getPassword();
        this.name = personaInputDto.getName();
        this.surname = personaInputDto.getSurname();
        this.company_email = personaInputDto.getCompany_email();
        this.personal_email = personaInputDto.getPersonal_email();
        this.city = personaInputDto.getCity();
        this.active = personaInputDto.isActive();
        this.created_date = personaInputDto.getCreated_date();
        this.imagen_url = personaInputDto.getImagen_url();
        this.termination_date = personaInputDto.getTermination_date();
    }

    public PersonaOutputDto personaToPersonaOutputDto(){
        return new PersonaOutputDto(this);
    }
}
