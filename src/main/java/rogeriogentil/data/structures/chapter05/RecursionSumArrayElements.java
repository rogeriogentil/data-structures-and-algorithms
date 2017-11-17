package rogeriogentil.data.structures.chapter05;

/**
 *
 * @author rogerio
 */
public class RecursionSumArrayElements {

   public static int sum(int[] array, int index) {
      int total = 0;
      
      if (array.length == 0 || index == array.length - 1) {
         return total;
      }
      
      return total + sum(array, index + 1);
   }
   
   public static void main(String[] args) {
      int[] array = {2, 1, 3, 5};
      int total = sum(array, 0);
      System.out.println("Total: " + total);
   }
}
