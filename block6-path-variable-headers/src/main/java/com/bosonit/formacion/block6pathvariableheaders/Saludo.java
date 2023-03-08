package com.bosonit.formacion.block6pathvariableheaders;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Esta clase al final no la use para el ejercicio,
la mantengo para la duda de por que no funciona el endpoint
si el JSON solo tiene 1 parametro
 */
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Saludo {
    private String texto;
    private int num;
}
