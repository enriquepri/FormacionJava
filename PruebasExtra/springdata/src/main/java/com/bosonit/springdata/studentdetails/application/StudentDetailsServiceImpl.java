package com.bosonit.springdata.studentdetails.application;

import com.bosonit.springdata.studentdetails.controller.dto.StudentDetailsInputDto;
import com.bosonit.springdata.studentdetails.controller.dto.StudentDetailsOutputDto;
import com.bosonit.springdata.student.domain.Student;
import com.bosonit.springdata.studentdetails.domain.StudentDetails;
import com.bosonit.springdata.studentdetails.repository.StudentDetailsRepository;
import com.bosonit.springdata.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDetailsServiceImpl implements StudentDetailsService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentDetailsRepository studentDetailsRepository;

    @Override
    public StudentDetailsOutputDto addDetailsToStudent(StudentDetailsInputDto studentDetailsInputDto) {
        Student student = studentRepository
                .findById(studentDetailsInputDto.getStudent_id())
                .orElseThrow();

        StudentDetails studentDetails = new StudentDetails(studentDetailsInputDto);

        student.setStudentDetails(studentDetails);
        studentDetails.setStudent(student);

        return studentDetailsRepository.save(studentDetails)
                .student_DetailsToStudent_DetailsOutputDto();
    }

    @Override
    public void deleteById(int id) {
        studentDetailsRepository.findById(id).orElseThrow();
        studentDetailsRepository.deleteById(id);
    }
}
