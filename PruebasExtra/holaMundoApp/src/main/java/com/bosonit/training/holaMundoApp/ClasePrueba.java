package com.bosonit.training.holaMundoApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClasePrueba implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde la clase prueba");
        for(String arg : args){
            System.out.println("Argumento " + arg);
        }
    }

}
