package rogeriogentil.data.structures.cap5;

/**
 *
 * @author rogerio
 */
public class RecursionBinarySearch {

   public static int search(int n, int[] array, int indexLowest, int indexHighest) {
      if (indexLowest > indexHighest) {
         return -1;
      }

      int middle = (indexHighest + indexLowest) / 2;
      int number = array[middle];

      if (n == number) {
         return middle;
      }

      if (n < number) {
         return search(n, array, indexLowest, middle - 1);
      } else {
         return search(n, array, middle + 1, indexHighest);
      }
   }
}
