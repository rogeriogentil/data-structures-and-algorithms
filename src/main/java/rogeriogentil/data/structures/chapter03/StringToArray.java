package rogeriogentil.data.structures.chapter03;

/**
 *
 * @author rogerio
 */
public class StringToArray {

   public static void main(String[] args) {
      String bird = "black bird";
      char[] characters = bird.toCharArray();
      
      for (int i = 0; i < characters.length; i++) {
         System.out.println("c[" + i + "]: " + characters[i]);
      }
      
      String newBird = new String(characters);
      System.out.println(newBird);
      
      char t = 'T';
      System.out.println(t);
   }
   
}
