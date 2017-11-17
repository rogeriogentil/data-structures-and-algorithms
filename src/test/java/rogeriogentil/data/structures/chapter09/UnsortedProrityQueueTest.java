package rogeriogentil.data.structures.chapter09;

import rogeriogentil.data.structures.chapter09.UnsortedProrityQueue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author rogerio
 */
public class UnsortedProrityQueueTest {

   @Test
   public void mustInstanceEmptyUnsortedPriorityQueue() {
      UnsortedProrityQueue<Integer, String> unsortedProrityQueue = new UnsortedProrityQueue<>();
      assertThat(unsortedProrityQueue.isEmpty(), is(true));
   }
   
   @Test
   public void mustInsert() {
      UnsortedProrityQueue<Integer, String> unsortedProrityQueue = new UnsortedProrityQueue<>();
      unsortedProrityQueue.insert(1, "A");
      
      assertThat(unsortedProrityQueue.size(), is(equalTo(1)));
   }
}
