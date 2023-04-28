package com.bosonit.springdata.course.domain;

import com.bosonit.springdata.course.controller.dto.CourseInputDto;
import com.bosonit.springdata.course.controller.dto.CourseOutputDto;
import com.bosonit.springdata.student.domain.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    Set<Student> students;

    public Course(CourseInputDto courseInputDto){
        this.id = courseInputDto.getId();
        this.name = courseInputDto.getName();
    }

    public CourseOutputDto courseToCourseOutputDto(){
        return new CourseOutputDto(
                this.id,
                this.name
        );
    }
}
