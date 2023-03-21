package com.bosonit.formacion.block7crudvalidation.profesor.domain;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorInputDto;
import com.bosonit.formacion.block7crudvalidation.profesor.infrastructure.controller.dto.ProfesorOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    private String comments;
    private String branch;
    @OneToMany(mappedBy = "profesor")
    private Set<Student> students;

    public Profesor (ProfesorInputDto profesorInputDto){
        this.id = profesorInputDto.getId();
        this.comments = profesorInputDto.getComments();
        this.branch = profesorInputDto.getBranch();
    }

    public ProfesorOutputDto profesorToProfesorOutputDto(){
        return new ProfesorOutputDto(this);
    }
}
