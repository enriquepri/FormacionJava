package com.bosonit.springdata.school.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolOutputDto {
    private int id;
    private String name;
    private String address;
}
