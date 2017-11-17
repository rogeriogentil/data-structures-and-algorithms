package rogeriogentil.data.structures.chapter05.reinforcement;

/**
 * Describe a recursive algorithm for finding the maximum element in an array, A, of n elements. 
 * What is your running time and space usage?
 * 
 * @author rogerio
 */
public class Exercise01 {
   
   public int maximumElement(int[] A, int index) {
      if (A.length == 1) {
         return A[0];
      }
      
      if (A[index] > A[index + 1]) {
         return A[index];
      }
      
      return maximumElement(A, index + 1);
   }
}
