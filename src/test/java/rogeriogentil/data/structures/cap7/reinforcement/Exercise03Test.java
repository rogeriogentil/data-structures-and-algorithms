package rogeriogentil.data.structures.cap7.reinforcement;

import org.junit.Test;
import rogeriogentil.data.structures.cap6.Deque;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise03Test {

   private Deque deque;

   @Test
   public void mustInstanceDequeWithoutElementsByDefault() {
      deque = new DequeArrayList();

      assertThat(deque.isEmpty(), is(true));
   }

   @Test
   public void mustInstanceDequeWithoutElementsEvenWhenCapacityIsProvided() {
      deque = new DequeArrayList(10);

      assertThat(deque.isEmpty(), is(true));
   }

   @Test
   public void mustAddAtBegin() {
      deque = new DequeArrayList();
      deque.addFirst(10);
      deque.addFirst(20);
      deque.addFirst(30);
      
      assertThat(deque.first(), is(equalTo(30)));
      assertThat(deque.size(), is(equalTo(3)));
   }

   @Test
   public void mustAddAtEnd() {
      deque = new DequeArrayList();
      deque.addLast(10);
      deque.addLast(20);
      deque.addLast(30);

      assertThat(deque.last(), is(equalTo(30)));
      assertThat(deque.size(), is(equalTo(3)));
   }

   @Test
   public void mustRemoveAtBegin() {
      deque = new DequeArrayList();
      deque.addFirst(10);
      deque.addFirst(20);
      deque.addFirst(30);

      assertThat(deque.removeFirst(), is(equalTo(30)));
      assertThat(deque.size(), is(equalTo(2)));
   }

   @Test
   public void mustRemoveAtEnd() {
      deque = new DequeArrayList();
      deque.addFirst(10);
      deque.addFirst(20);
      deque.addFirst(30);

      assertThat(deque.removeLast(), is(equalTo(10)));
      assertThat(deque.size(), is(equalTo(2)));
   }
}
