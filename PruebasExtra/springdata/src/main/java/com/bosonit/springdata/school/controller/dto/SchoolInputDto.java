package com.bosonit.springdata.school.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolInputDto {
    private int id;
    private String name;
    private String address;
}
