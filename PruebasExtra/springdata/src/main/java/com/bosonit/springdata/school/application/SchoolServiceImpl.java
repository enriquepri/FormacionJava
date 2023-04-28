package com.bosonit.springdata.school.application;

import com.bosonit.springdata.school.controller.dto.SchoolInputDto;
import com.bosonit.springdata.school.controller.dto.SchoolOutputDto;
import com.bosonit.springdata.school.repository.SchoolRepository;
import com.bosonit.springdata.school.domain.School;
import com.bosonit.springdata.student.controller.dto.StudentOutputDto;
import com.bosonit.springdata.student.domain.Student;
import com.bosonit.springdata.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public SchoolOutputDto addSchool(SchoolInputDto schoolInputDto) {
        return schoolRepository.save(new School(schoolInputDto))
                .schoolToSchoolOutputDto();
    }

    @Override
    public void addStudentToSchool(int student_id, int school_id) {
        Student student = studentRepository.findById(student_id).orElseThrow();
        School school = schoolRepository.findById(school_id).orElseThrow();

        student.setSchool(school);
        school.getStudents().add(student);

        studentRepository.save(student);
        schoolRepository.save(school);
    }

    @Override
    public List<String> getAllStudents(int school_id) {
        School school = schoolRepository.findById(school_id).orElseThrow();

        return school.getStudents().stream().map(Student::getName).collect(Collectors.toList());
    }

    @Override
    public Iterable<StudentOutputDto> getDtos(int school_id) {
        School school = schoolRepository.findById(school_id).orElseThrow();

        return school.getStudents().stream().map(Student::studentToStudentOutputDTO).toList();
    }
}
