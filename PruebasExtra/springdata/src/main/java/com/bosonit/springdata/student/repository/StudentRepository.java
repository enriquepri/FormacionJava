package com.bosonit.springdata.student.repository;

import com.bosonit.springdata.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
