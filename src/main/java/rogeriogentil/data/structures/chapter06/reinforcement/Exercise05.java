
package rogeriogentil.data.structures.chapter06.reinforcement;

import rogeriogentil.data.structures.chapter06.Stack;

/**
 * R-6.5 Give a recursive method for removing all the elements from a stack.
 * 
 * @author Rogerio J. Gentil
 * @param <E>
 */
public class Exercise05<E> {

   public void removeAll(Stack<E> stack) {
      if (stack.pop() == null) {
         return;
      }
      stack.pop();
      removeAll(stack);
   }
}
