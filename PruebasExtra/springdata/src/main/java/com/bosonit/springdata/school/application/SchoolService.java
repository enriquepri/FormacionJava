package com.bosonit.springdata.school.application;

import com.bosonit.springdata.school.controller.dto.SchoolInputDto;
import com.bosonit.springdata.school.controller.dto.SchoolOutputDto;
import com.bosonit.springdata.student.controller.dto.StudentOutputDto;
import com.bosonit.springdata.student.domain.Student;

public interface SchoolService {
    SchoolOutputDto addSchool(SchoolInputDto schoolInputDto);
    void addStudentToSchool(int student_id, int school_id);
    Iterable<String> getAllStudents(int school_id);
    Iterable<StudentOutputDto> getDtos(int school_id);
}
