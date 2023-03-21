package com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto;

import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    private Integer id;
    private int num_hours_week;
    private String comments;
    private String branch;
    private Integer id_persona;

    public StudentOutputDto(Student student) {
        this.id = student.getId();
        this.num_hours_week = student.getNum_hours_week();
        this.comments = student.getComments();
        this.branch = student.getBranch();
        this.id_persona = student.getPersona().getId_persona();
    }
}
