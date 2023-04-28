package com.bosonit.springdata.school.domain;

import com.bosonit.springdata.school.controller.dto.SchoolInputDto;
import com.bosonit.springdata.school.controller.dto.SchoolOutputDto;
import com.bosonit.springdata.student.domain.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class School {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "school")
    private Set<Student> students;

    public School(SchoolInputDto schoolInputDto){
        this.id = schoolInputDto.getId();
        this.name = schoolInputDto.getName();
        this.address = schoolInputDto.getAddress();
    }

    public SchoolOutputDto schoolToSchoolOutputDto(){
        return new SchoolOutputDto(
                this.id,
                this.name,
                this.address
        );
    }
}
