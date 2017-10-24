package rogeriogentil.data.structures.cap5;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author rogerio
 */
public class RecursionBinarySearchTest {

   @Test
   public void deveEncontrarNumeroNoMeio() {
      int[] array = {0, 10, 20, 30, 40};
      int numero = 20;
      
      int index = RecursionBinarySearch.search(numero, array, 0, array.length - 1);
      
      Assert.assertEquals(2, index);
   }
   
   @Ignore
   @Test
   public void deveEncontrarNumeroADireta() {
      int[] array = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90};
      int numero = 30;
      
      int index = RecursionBinarySearch.search(numero, array, 0, array.length - 1);
      
      Assert.assertEquals(4, index);
   }
   
   @Ignore
   @Test
   public void deveEncontrarNumeroAEsquerda() {
      int[] array = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
      int numero = 90;
      
      int index = RecursionBinarySearch.search(numero, array, 0, array.length - 1);
      
      Assert.assertEquals(10, index);
   }
}

