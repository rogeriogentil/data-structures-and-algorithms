package rogeriogentil.data.structures.chapter06.reinforcement;

import rogeriogentil.data.structures.chapter06.Stack;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise04 {
   
   public static <E> void transfer(Stack<E> s, Stack<E> t) {
      if (s.isEmpty()) {
         throw new IllegalStateException("Stack S is empty!");
      }
      
      while (s.top() != null) {
         t.push(s.pop());
      }
   }
}
