package com.bosonit.formacion.block7crudvalidation.asignatura.application;

import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaInputDto;
import com.bosonit.formacion.block7crudvalidation.asignatura.infrastructure.controller.dto.AsignaturaOutputDto;

public interface AsignaturaService {
    public AsignaturaOutputDto addAsignatura(AsignaturaInputDto asignaturaInputDto);
    public Iterable<AsignaturaOutputDto> getAllAsignaturas();
    public Iterable<AsignaturaOutputDto> getAsignaturasFromStudent(Integer student_id);
    public void addStudentToAsignatura(int asignatura_id, int student_id);
    public void deleteById(Integer asignatura_id);
    public AsignaturaOutputDto updateAsignatura(AsignaturaInputDto asignaturaInputDto);
}
