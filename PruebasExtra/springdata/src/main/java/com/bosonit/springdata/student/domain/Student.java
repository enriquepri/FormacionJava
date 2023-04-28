package com.bosonit.springdata.student.domain;

import com.bosonit.springdata.course.domain.Course;
import com.bosonit.springdata.school.domain.School;
import com.bosonit.springdata.studentdetails.domain.StudentDetails;
import com.bosonit.springdata.student.controller.dto.StudentInputDto;
import com.bosonit.springdata.student.controller.dto.StudentOutputDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String name;
    String lastName;

    @OneToOne
    private StudentDetails studentDetails;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToMany
    private Set<Course> courses;

    public Student (StudentInputDto studentInputDto){
        this.id = studentInputDto.getId();
        this.name = studentInputDto.getName();
        this.lastName = studentInputDto.getLastName();
    }

    public StudentOutputDto studentToStudentOutputDTO(){
        return new StudentOutputDto(
                this.id,
                this.name,
                this.lastName
        );
    }
}
