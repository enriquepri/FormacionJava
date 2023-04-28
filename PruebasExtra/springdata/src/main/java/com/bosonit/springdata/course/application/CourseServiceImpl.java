package com.bosonit.springdata.course.application;

import com.bosonit.springdata.course.controller.dto.CourseInputDto;
import com.bosonit.springdata.course.controller.dto.CourseOutputDto;
import com.bosonit.springdata.course.domain.Course;
import com.bosonit.springdata.course.repository.CourseRepository;
import com.bosonit.springdata.student.domain.Student;
import com.bosonit.springdata.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public CourseOutputDto addCourse(CourseInputDto courseInputDto) {
        return courseRepository
                .save(new Course(courseInputDto))
                .courseToCourseOutputDto();
    }

    @Override
    public void addCoursesToStudent(int course_id, int student_id) {
        Student student = studentRepository.findById(student_id).orElseThrow();
        Course course = courseRepository.findById(course_id).orElseThrow();

        student.getCourses().add(course);
        studentRepository.save(student);
    }
}
