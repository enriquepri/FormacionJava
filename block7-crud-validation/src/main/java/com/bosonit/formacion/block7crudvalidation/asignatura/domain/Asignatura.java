package com.bosonit.formacion.block7crudvalidation.asignatura.domain;

import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue
    Integer id;
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    Student student;

    public Asignatura(AsignaturaInputDto asignaturaInputDto){
        this.id = asignaturaInputDto.getId();
        this.asignatura = asignaturaInputDto.getAsignatura();
        this.comments = asignaturaInputDto.getComments();
    }

    public AsignaturaOutputDto asignaturaToAsignaturaOutputDto(){
        return new AsignaturaOutputDto(this);
    }
}
