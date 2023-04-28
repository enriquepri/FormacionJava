package com.bosonit.springdata.course.application;

import com.bosonit.springdata.course.controller.dto.CourseInputDto;
import com.bosonit.springdata.course.controller.dto.CourseOutputDto;

public interface CourseService {
    public CourseOutputDto addCourse(CourseInputDto courseInputDto);
    void addCoursesToStudent(int course_id, int student_id);
}
