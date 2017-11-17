package rogeriogentil.data.structures.chapter03;

import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.*;

/**
 *
 * @author rogerio
 */
public class ArraysTest {

   @Test
   public void devemSerArraysIguais() {
      int[] a = {0, 1, 2, 3, 4};
      int[] b = {0, 1, 2, 3, 4};

      assertTrue(Arrays.equals(a, b));
   }

   @Test
   public void naoDevemSerArraysIguais() {
      int[] a = {4, 3, 2, 1, 0};
      int[] b = {0, 1, 2, 3, 4};

      assertFalse(Arrays.equals(a, b));
   }
   
   @Test
   public void devePrencherArrayComValorUnico() {
      int[] array = new int[5];
      
      Arrays.fill(array, 5);
      
      for (int i = 0; i < array.length; i++) {
         assertTrue(array[i] == 5);
      }
   }
   
   @Test
   public void deveObterPorBuscaBinaria() {
      int[] array = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
      
      int index = Arrays.binarySearch(array, 14);
      
      assertEquals(index, 7);
   }
}
