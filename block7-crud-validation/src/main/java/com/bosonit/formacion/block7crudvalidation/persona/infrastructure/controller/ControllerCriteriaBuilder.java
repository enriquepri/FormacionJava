package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller;

import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/cb")
public class ControllerCriteriaBuilder {
    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("/getAll")
    public Iterable<PersonaOutputDto> getAllPersonasCB(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "surname") String surname,
            @RequestParam(required = false, name = "username") String username,
            @RequestParam(required = false, name = "order") String order,
            @RequestParam(required=false, name = "date") @DateTimeFormat(pattern="dd-MM-yyyy") Date createdDate,
            @RequestParam(required = false, name = "dateCondition") String dateCondition,
            @RequestParam(required = true, name = "numPag") Integer numPag,
            @RequestParam(required = false, name = "tamPag") Integer tamPag
    ){
        HashMap<String, Object> conditions= new HashMap<>();

        if(createdDate!=null){
            if(dateCondition!= null && (dateCondition.equals("less") || dateCondition.equals("greater") || dateCondition.equals("equal")))
                conditions.put("dateCondition", dateCondition);
            else
                conditions.put("dateCondition", "greater");

            conditions.put("created_date", createdDate);
        }

        if(name!=null)
            conditions.put("name", name);
        if(surname!=null)
            conditions.put("surname", surname);
        if(username!=null)
            conditions.put("username", username);
        if(order!=null)
            conditions.put("order", order);
        if(tamPag!=null)
            conditions.put("tamPag", tamPag);

        conditions.put("pag", numPag-1);

        System.out.println(createdDate);

        return personaRepository.getPersonalizado(conditions);
    }
}
