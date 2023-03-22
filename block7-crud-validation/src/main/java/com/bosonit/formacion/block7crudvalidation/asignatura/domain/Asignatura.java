package com.bosonit.formacion.block7crudvalidation.asignatura.domain;

import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Asignatura {
    @Id
    @GeneratedValue
    Integer id;
    String nombre;
    String comments;
    //Date initial_date;
    //Date finish_date;
    @ManyToMany(mappedBy = "asignaturas")
    Set<Student> students;

    public Asignatura(AsignaturaInputDto asignaturaInputDto) {
        this.id = asignaturaInputDto.getId();
        this.nombre = asignaturaInputDto.getNombre();
        this.comments = asignaturaInputDto.getComments();
    }

    public AsignaturaOutputDto asignaturaToAsignaturaOutputDto() {
        return new AsignaturaOutputDto(this);
    }
}
