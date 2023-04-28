package com.bosonit.springdata.studentdetails.application;

import com.bosonit.springdata.studentdetails.controller.dto.StudentDetailsInputDto;
import com.bosonit.springdata.studentdetails.controller.dto.StudentDetailsOutputDto;

public interface StudentDetailsService {
    public StudentDetailsOutputDto addDetailsToStudent (StudentDetailsInputDto studentDetailsInputDto);
    public void deleteById(int id);
}
