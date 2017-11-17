package rogeriogentil.data.structures.chapter03;

/**
 *
 * @author rogerio
 */
public class InsertionSort {
   
   public Integer[] sort(Integer[] array) {
      
      for (int i = 1; i < array.length; i++) {
         int valorAtual = array[i];
         int j = i;       
         
         while (j > 0 && valorAtual < array[j - 1]) {
            array[j] = array[j -1];
            j--;
         }
         
         array[j] = valorAtual;
      }
      
      return array;
   }
}
