
package rogeriogentil.data.structures.cap5;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rogerio
 */
public class RecursionFibonacciTest {

   @Test
   public void deveRetornarQuartoNumeroDeFibonacci() {
      long n = RecursionFibonacci.get(6);
      Assert.assertEquals(24, n);
   }
}
