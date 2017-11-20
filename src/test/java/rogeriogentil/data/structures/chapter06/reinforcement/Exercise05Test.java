package rogeriogentil.data.structures.chapter06.reinforcement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import rogeriogentil.data.structures.chapter06.ArrayStack;
import rogeriogentil.data.structures.chapter06.Stack;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise05Test {

   @Test
   public void mustRemoveAllElementsRecursively() {
      Stack<Integer> stack = new ArrayStack<>();
      stack.push(10);
      stack.push(20);
      stack.push(30);
      stack.push(40);
      
      Exercise05<Integer> ex05 = new Exercise05<>();
      ex05.removeAll(stack);
      
      assertThat(stack.isEmpty(), is(true));
   }
}
