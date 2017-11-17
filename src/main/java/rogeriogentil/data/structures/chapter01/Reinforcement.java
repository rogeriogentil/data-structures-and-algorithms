package rogeriogentil.data.structures.chapter01;

/**
 *
 * @author rogerio
 */
public class Reinforcement {

   public static void main(String[] args) {
      Reinforcement r = new Reinforcement();

      // R-1.3 
      System.out.println(r.isMultiple(2, 6));
      System.out.println(r.isMultiple(3, 6));
      System.out.println(r.isMultiple(4, 9));

      // R-1.5
      System.out.println("R-1.5");
      System.out.println(r.sumInts(3));
      System.out.println(r.sumInts(5));
//      System.out.println(r.sumInts(-1));

      // R-1.6
      System.out.println("R-1.6");
      System.out.println(r.sumOdds(3));
      System.out.println(r.sumOdds(4));
      System.out.println(r.sumOdds(5));
      
      // R-1.7
      System.out.println("R-1.7");
      System.out.println(r.sumSquaers(2));
      System.out.println(r.sumSquaers(3));
      
      // R-1.8
      System.out.println("R-1.8");
      System.out.println(r.countVowels(""));
      System.out.println(r.countVowels("aeiou"));
      System.out.println(r.countVowels("Rogerio"));
      System.out.println(r.countVowels("PAULA"));
      
   }

   /**
    * R-1.3
    *
    * @param n
    * @param m
    * @return
    */
   public boolean isMultiple(long n, long m) {
      return m % n == 0;
   }

   /**
    * R-1.4 - This method cannot use the multiplication, modulus, or division operators.
    */
   public boolean isEven(int i) {
      return false;
   }

   /**
    * R-1.5 Write a short Java method that takes an integer n and returns the sum of all positive integers less than or
    * equal to n.
    */
   public long sumInts(int n) {
      if (n < 0) {
         throw new RuntimeException("Não é possível somar números negativos.");
      }

      long sum = 0;
      for (int i = n; i > 0; --i) {
         sum += i;
      }

      return sum;
   }

   /**
    * R-1.6 Write a short Java method that takes an integer n and returns the sum of all the odd positive integers less
    * than or equal to n.
    */
   public long sumOdds(int n) {
      if (n < 0) {
         throw new RuntimeException("Não é possível somar números negativos.");
      }

      long sum = 0;
      for (int i = n; i > 0; --i) {
         if (i % 2 == 1) {
            sum += i;
         }
      }

      return sum;
   }

   /**
    * R-1.7 Write a short Java method that takes an integer n and returns the sum of the squares of all positive
    * integers less than or equal to n.
    */
   public long sumSquaers(int n) {
      if (n < 0) {
         throw new RuntimeException("Não é possível somar números negativos.");
      }

      long sum = 0;
      for (int i = n; i > 0; --i) {
         sum += i * i;
      }

      return sum;
   }
   
   /**
    * R-1.8 Write a short Java method that counts the number of vowels in a given character string.
    */
   public int countVowels(String s) {
      int count = 0;
      String sl = s.toLowerCase();
      
      for (int i = 0; i < s.length(); i++) {
         char c = sl.charAt(i);
         switch(c) {
            case 'a': count++; break;
            case 'e': count++; break;
            case 'i': count++; break;
            case 'o': count++; break;
            case 'u': count++; break;
         }
      }
      
      return count;
   }
}
