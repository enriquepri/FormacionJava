package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaInputDto {
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

    public PersonaInputDto(String username,
                           String password,
                           String name,
                           String surname,
                           String company_email,
                           String personal_email,
                           String city,
                           String imagen_url) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.imagen_url = imagen_url;
    }
}
