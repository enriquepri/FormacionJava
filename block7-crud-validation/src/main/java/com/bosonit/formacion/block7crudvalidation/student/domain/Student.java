package com.bosonit.formacion.block7crudvalidation.student.domain;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.controller.dto.StudentOutputDtoCompleto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    private int num_hours_week;
    private String comments;
    /*@ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;*/
    private String branch;

    public Student(StudentInputDto studentInputDto){
        this.num_hours_week = studentInputDto.getNum_hours_week();
        this.comments = studentInputDto.getComments();
        this.branch = studentInputDto.getBranch();
    }

    public StudentOutputDtoCompleto studentToStudentOutputDtoCompleto(){
        return new StudentOutputDtoCompleto(
                this.id,
                this.num_hours_week,
                this.comments,
                this.branch,
                this.persona.getId_persona(),
                this.persona.getUsername(),
                this.persona.getPassword(),
                this.persona.getName(),
                this.persona.getSurname(),
                this.persona.getCompany_email(),
                this.persona.getPersonal_email(),
                this.persona.getCity(),
                this.persona.isActive(),
                this.persona.getCreated_date(),
                this.persona.getImagen_url(),
                this.persona.getTermination_date()
        );
    }

    public StudentOutputDto studentToStudentOutputDto(){
        return new StudentOutputDto(
                this.id,
                this.num_hours_week,
                this.comments,
                this.branch,
                this.persona.getId_persona()
        );
    }
}
