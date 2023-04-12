package com.bosonit.formacion.block10dockerizeapp.repository;

import com.bosonit.formacion.block10dockerizeapp.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
