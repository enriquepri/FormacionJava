import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class CalculadoraTest {

    @Test
    void suma() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.suma(32, 94);
        assertThat(resultado, is(126));
    }

    @Test
    void resta() {
    }

    @Test
    void division() {
    }

    @Test
    void multiplicacion() {
    }

    @Test
    public void testPrueba() {
        Calculadora calculadora1 = new Calculadora();
        assertThat("10 X 0 debe de ser 0", calculadora1.multiplicacion(10, 0), equalTo(0));
    }
}