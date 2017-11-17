
package rogeriogentil.data.structures.chapter05;

import rogeriogentil.data.structures.chapter05.RecursionFibonacci;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author rogerio
 */
public class RecursionFibonacciTest {

   @Ignore
   @Test
   public void deveRetornarQuartoNumeroDeFibonacci() {
      long n = RecursionFibonacci.get(6);
      Assert.assertEquals(24, n);
   }
}
