package com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDtoCompleto extends StudentOutputDto{
    String username;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean is_active;
    Date created_date;
    String imagen_url;
    Date termination_date;

    /*public StudentOutputDtoCompleto(Integer id,
                                    int num_hours_week,
                                    String comments,
                                    String branch,
                                    Integer id_persona,
                                    String username,
                                    String password,
                                    String name,
                                    String surname,
                                    String company_email,
                                    String personal_email,
                                    String city,
                                    Boolean is_active,
                                    Date created_date,
                                    String imagen_url,
                                    Date termination_date) {
        super(id, num_hours_week, comments, branch, id_persona);
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.is_active = is_active;
        this.created_date = created_date;
        this.imagen_url = imagen_url;
        this.termination_date = termination_date;
    }*/
    public StudentOutputDtoCompleto(Student student) {
        super(student);
        this.username = student.getPersona().getUsername();
        this.password = student.getPersona().getPassword();
        this.name = student.getPersona().getName();
        this.surname = student.getPersona().getSurname();
        this.company_email = student.getPersona().getCompany_email();
        this.personal_email = student.getPersona().getPersonal_email();
        this.city = student.getPersona().getCity();
        this.is_active = student.getPersona().isActive();
        this.created_date = student.getPersona().getCreated_date();
        this.imagen_url = student.getPersona().getImagen_url();
        this.termination_date = student.getPersona().getTermination_date();
    }
}
