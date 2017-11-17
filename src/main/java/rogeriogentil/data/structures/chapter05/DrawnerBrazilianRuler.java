package rogeriogentil.data.structures.chapter05;

/**
 *
 * @author rogerio
 */
public class DrawnerBrazilianRuler {
   
   public static void drawRuler(int nroCentimetros, int majorLenth) {
      drawLine(majorLenth, 0);
      for (int j = 1; j <= nroCentimetros; j++) {
         drawInterval(majorLenth - 1);
         drawLine(majorLenth, j);
      }
   }
   
   public static void drawInterval(int centralLength) {
      if (centralLength >= 1) {
         drawInterval(centralLength - 1);
         drawLine(centralLength);
         drawInterval(centralLength - 1);
      }
   }
   
   public static void drawLine(int tickLength) {
      drawLine(tickLength, - 1);
   }
   
   public static void drawLine(int tickLength, int tickLabel) {
      for (int j = 0; j < tickLength; j++) {
         System.out.print("-");
      }
      
      if (tickLabel >= 0) {
         System.out.print(" " + tickLabel);
      }
      
      System.out.print("\n");
   }
   
   public static void main(String[] args) {
      DrawnerBrazilianRuler.drawRuler(5, 3);
   }
}
