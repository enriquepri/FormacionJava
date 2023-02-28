package com.bosonit.formacion.block5logging;

import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CLaseLogs implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n\nENTRA LA CLASE DE LOGS\n\n");
        log.trace("Mensaje a nivel de TRACE");
        log.debug("Mensaje a nivel de DEBUG");
        log.info("Mensaje a nivel de INFO");
        log.warn("Mensaje a nivel de WARNING");
        log.error("Mensaje a nivel de ERROR");
    }
}
