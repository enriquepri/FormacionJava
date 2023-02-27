package com.bosonit.formacion.block5commandlinerunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClaseSecundaria implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde la clase secundaria");
        for(String argu : args){
            System.out.println("Argumento: " + argu);
        }
    }
}
