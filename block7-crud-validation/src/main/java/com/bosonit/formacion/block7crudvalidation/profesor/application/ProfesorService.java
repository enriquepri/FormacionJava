package com.bosonit.formacion.block7crudvalidation.profesor.application;

import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.infrastructure.controller.dto.StudentOutputDto;

public interface ProfesorService {
    ProfesorOutputDto profesorAdd(ProfesorInputDto profesorInputDto);
    ProfesorOutputDto getProfesor (Integer id);
    Iterable<ProfesorOutputDto> getAllProfesors();
    Iterable<StudentOutputDto> getAllStudentsFromProfesor(int profesor_id);
    void addStudentToProfesor(int profesor_id, int student_id);
    void deleteProfesorById(Integer profesor_id);
    ProfesorOutputDto updateProfesor(ProfesorInputDto profesorInputDto);
}
