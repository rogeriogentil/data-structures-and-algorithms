package rogeriogentil.data.structures.cap5;

/**
 *
 * @author rogerio
 */
public class RecursionFibonacci {

   public static int get(int thElement) {
      if (thElement <= 1) {
         return 1;
      } else {
         return get(thElement - 1) + get(thElement - 2);
      }
   }
}
