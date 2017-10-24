package rogeriogentil.data.structures.cap7.reinforcement;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise02Test {

   @Test
   public void mustInstanceStackWithoutElements() {
      StackArrayList<Integer> stack = new StackArrayList<>();

      assertThat(stack.isEmpty(), is(true));
   }

   @Test
   public void mustReturnSize() {
      StackArrayList<Integer> stack = new StackArrayList<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);

      assertThat(stack.size(), is(equalTo(3)));
   }

   @Test
   public void mustInsertOnTop() {
      StackArrayList<Integer> stack = new StackArrayList<>();
      stack.push(10);
      stack.push(20);
      stack.push(30);

      assertThat(stack.top(), is(equalTo(30)));
   }

   @Test
   public void mustGetElementOnTop() {
      StackArrayList<Integer> stack = new StackArrayList<>();
      stack.push(10);
      stack.push(20);

      assertThat(stack.top(), is(equalTo(20)));
   }

   @Test
   public void mustRemoveElementOfTheTop() {
      StackArrayList<Integer> stack = new StackArrayList<>();
      stack.push(10);
      stack.push(20);
      stack.push(30);

      Integer popped = stack.pop();

      assertThat(popped, is(equalTo(30)));
      assertThat(stack.top(), is(equalTo(20)));
   }
}
