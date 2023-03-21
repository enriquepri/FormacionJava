package com.bosonit.formacion.block7crudvalidation.student.domain;

import com.bosonit.formacion.block7crudvalidation.asignatura.domain.Asignatura;
import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.profesor.domain.Profesor;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentInputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDtoCompleto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
    private String branch;
    @OneToMany(mappedBy = "student")
    Set<Asignatura> asignaturas;

    public Student(StudentInputDto studentInputDto){
        this.num_hours_week = studentInputDto.getNum_hours_week();
        this.comments = studentInputDto.getComments();
        this.branch = studentInputDto.getBranch();
    }

    public StudentOutputDto studentToStudentOutputDto(){
        return new StudentOutputDto(this);
    }

    public StudentOutputDtoCompleto studentToStudentOutputDtoCompleto(){
        return new StudentOutputDtoCompleto(this);
    }
}
