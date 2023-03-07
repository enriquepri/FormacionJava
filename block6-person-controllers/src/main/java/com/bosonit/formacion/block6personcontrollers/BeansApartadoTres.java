package com.bosonit.formacion.block6personcontrollers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Se acceden desde controlador 2
@Configuration
public class BeansApartadoTres {
    @Bean
    @Qualifier("bean1")
    Persona bean1(){
        Persona person = new Persona("bean1", "bean1", 1);
        return person;
    }

    @Bean
    @Qualifier("bean2")
    Persona bean2(){
        Persona person = new Persona("bean2", "bean2", 2);
        return person;
    }

    @Bean
    @Qualifier("bean3")
    Persona bean3(){
        Persona person = new Persona("bean3", "bean3", 3);
        return person;
    }
}
