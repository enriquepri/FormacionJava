package com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInputDto {
    private Integer id;
    private int persona_id;
    private int num_hours_week;
    private String comments;
    private String branch;
}
