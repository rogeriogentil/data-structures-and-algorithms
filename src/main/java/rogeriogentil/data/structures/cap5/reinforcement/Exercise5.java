package rogeriogentil.data.structures.cap5.reinforcement;

/**
 *
 * @author rogerio
 */
public class Exercise5 {

   public static int[] reverseArray(int[] array, int beginIndex, int endIndex) {
      if (beginIndex > endIndex) {
         return array;
      }
      
      int aux = array[beginIndex];
      array[beginIndex] = array[endIndex];
      array[endIndex] = aux;
      
      return reverseArray(array, beginIndex + 1, endIndex - 1);
   }
   
   public static void main(String[] args) {
      int[] data = {4, 3, 6, 2, 6};
      int[] dataReverse = reverseArray(data, 0, 4);
      
      for (int i = 0; i < dataReverse.length; i++) {
         System.out.print(dataReverse[i] + " ");
      }
   }
}
