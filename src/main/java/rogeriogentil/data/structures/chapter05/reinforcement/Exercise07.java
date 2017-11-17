package rogeriogentil.data.structures.chapter05.reinforcement;

/**
 *
 * @author rogerio
 */
public class Exercise07 {

   /**
    * Somatória 1/k, k = 1 até n
    * 
    * ex: 1 + 1/2 + 1/3 + 1/4 + ...
    * 
    * @return 
    */
   public static double getNthHarmonicNumber(int nth) {
      if (nth < 1) {
         throw new IllegalArgumentException("Parâmetro não pode ser menor que 1");
      } 
      
      if (nth == 1) 
         return 1;
      
      return (double) 1 / nth + getNthHarmonicNumber(nth - 1);
   }
   
   public static void main(String[] args) {
      double n = getNthHarmonicNumber(2);
      System.out.println("n = " + n);
   }
}
