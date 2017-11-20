package rogeriogentil.data.structures.chapter06.reinforcement;

import rogeriogentil.data.structures.chapter06.Stack;

/**
 * R-6.4 Implement a method with signature transfer(S, T ) that transfers all elements from stack S onto stack T , so 
 * that the element that starts at the top of S is the first to be inserted onto T , and the element at the bottom of 
 * S ends up at the top of T.
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
