package rogeriogentil.data.structures.chapter03;

import rogeriogentil.data.structures.chapter03.InsertionSort;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 *
 * @author rogerio
 */
public class InsertionSortTest {

   @Test
   public void deveOrdernarQuandoArrayEstaCheio() {
      Integer[] arrayDesordenado = new Integer[5]; // não pode ser int por usar Generics!!
      arrayDesordenado[0] = 3;
      arrayDesordenado[1] = 6;
      arrayDesordenado[2] = 9;
      arrayDesordenado[3] = 4;
      arrayDesordenado[4] = 1;
      
      InsertionSort insertionSort = new InsertionSort();
      Integer[] arrayOrdenado = insertionSort.sort(arrayDesordenado);
           
      for (int i = 1; i < arrayOrdenado.length; i++) {
         MatcherAssert.assertThat("", arrayDesordenado[i] > arrayDesordenado[i - 1]);
      }
   }
}
