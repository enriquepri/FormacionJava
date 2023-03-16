package com.bosonit.formacion.block7crudvalidation.student.controller.dto;

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
}
