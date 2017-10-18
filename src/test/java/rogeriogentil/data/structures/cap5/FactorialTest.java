package rogeriogentil.data.structures.cap5;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author rogerio
 */
public class FactorialTest {

   @Test
   public void deveRetornarFatorialDeTres() {
      int n = 3;
      long resultado = Factorial.factorial(n);

      assertEquals(6, resultado);
   }
}
