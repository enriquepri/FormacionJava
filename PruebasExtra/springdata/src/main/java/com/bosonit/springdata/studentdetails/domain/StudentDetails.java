package com.bosonit.springdata.studentdetails.domain;

import com.bosonit.springdata.studentdetails.controller.dto.StudentDetailsInputDto;
import com.bosonit.springdata.studentdetails.controller.dto.StudentDetailsOutputDto;
import com.bosonit.springdata.student.domain.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String address;
    private String phone_number;
    @OneToOne
    @JoinColumn(name = "Student_Id", nullable = false, unique = true)
    private Student student;

    public StudentDetails(StudentDetailsInputDto studentDetailsInputDto){
        this.address = studentDetailsInputDto.getAddress();
        this.phone_number = studentDetailsInputDto.getPhone_number();
    }

    public StudentDetailsOutputDto
    student_DetailsToStudent_DetailsOutputDto(){
        return new StudentDetailsOutputDto(
                this.id,
                this.address,
                this.phone_number,
                this.student.getId(),
                this.student.getName(),
                this.student.getLastName()
        );
    }
}
