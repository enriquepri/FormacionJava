package com.bosonit.springdata.course.repository;

import com.bosonit.springdata.course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
