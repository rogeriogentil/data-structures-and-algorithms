package rogeriogentil.data.structures.chapter01;

/**
 *
 * @author rogerio
 */
public class Creativity {

   public static void main(String[] args) {
      Creativity creativity = new Creativity();
      
      // C-1.14
      int[] integers = {0, 2, 4, 6, 8};
      int[] reverse = creativity.reverse(integers);
      
      System.out.print("{");
      for(Integer i : reverse) {
         System.out.print(i + ", ");
      }
      System.out.println("}");
      
      // C-1.15
      int smallest = creativity.smallest(integers);
      System.out.println("Smallest = " + smallest);
      
      int smallest2 = creativity.smallest(new int[5]);
      System.out.println("Smallest = " + smallest2);
      
      int[] ints = {-3, -1, 0, 1, 3};
      int smallest3 = creativity.smallest(ints);
      System.out.println("Smallest = " + smallest3);
   }
   
   /** 
    * C-1.14
    */
   public int[] reverse(int[] array) {
      int[] reverse = new int[array.length];
      
      int j = 0;
      for (int i = array.length - 1; i > 0; i--) {
         reverse[j++] = array[i];         
      }
      
      return reverse;
   }
   
   /**
    * C-1.15
    */
   public int smallest(int[] array) {
      int smallest = array[0];
      
      for (int i = 1; i < array.length; i++) {
         if (array[i] < smallest) {
            smallest = array[i];
         }
      }
      
      return smallest;
   }
}
