package com.bosonit.springdata.course.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseOutputDto {
    private int id;
    private String name;
}
