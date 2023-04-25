package com.bosonit.formacion.block7crudvalidation.persona.infrastructure.repository;

import com.bosonit.formacion.block7crudvalidation.persona.domain.Persona;
import com.bosonit.formacion.block7crudvalidation.persona.infrastructure.controller.dto.PersonaOutputDto;
import com.bosonit.formacion.block7crudvalidation.student.domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

//Al llamarse igual que PersonaRepository pero con el añadido Impl Spring lo detecta automaticamente cuando queramos acceder a nuestra query personalizada
public class PersonaRepositoryImpl {

    @PersistenceContext
    EntityManager entityManager;

    public List<PersonaOutputDto> getPersonalizado(HashMap<String, Object> conditions){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query= cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);

        List<Predicate> predicates = new ArrayList<>();

        conditions.forEach((field, value) ->{
            switch (field){
                case "name":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "surname":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "username":
                    predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
                    break;
                case "created_date":
                    String dateCondition = (String)conditions.get("dateCondition");
                    switch (dateCondition){
                        case "greater":
                            predicates.add(cb.greaterThan(root.<Date>get(field), (Date)value));
                            break;
                        case "less":
                            predicates.add(cb.lessThan(root.<Date>get(field), (Date)value));
                            break;
                        case "equal":
                            predicates.add(cb.equal(root.<Date>get(field), (Date)value));
                            break;
                    }
            }
        });
        query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

        if(conditions.containsKey("order")){
            String ordenar = (String)conditions.get("order");
            switch (ordenar){
                case "name":
                    query.orderBy(cb.desc(root.get("name")));
                    break;
                case "user":
                    query.orderBy(cb.desc(root.get("username")));
                    break;
            }
        }

        int pagina = 0;
        int tamPag = 10;

        if(conditions.containsKey("pag")){
            pagina = (Integer)conditions.get("pag");
        }
        if(conditions.containsKey("tamPag")){
            tamPag = (Integer)conditions.get("tamPag");
        }

        return entityManager.createQuery(query)
                .setFirstResult(pagina * tamPag)
                .setMaxResults(tamPag)
                .getResultList()
                .stream()
                .map(Persona::personaToPersonaOutputDto)
                .toList();
    }
}
