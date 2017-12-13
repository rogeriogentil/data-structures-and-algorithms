package rogeriogentil.data.structures.chapter12;


import org.junit.Test;
import rogeriogentil.data.structures.chapter06.LinkedQueue;
import rogeriogentil.data.structures.chapter06.Queue;
import rogeriogentil.data.structures.chapter09.DefaultComparator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rogerio J. Gentil
 */
public class QuickSortTest {

    @Test
    public void mustOrderUsingQueueAproach() {
        Queue<Integer> q = new LinkedQueue<>();
        q.enqueue(8);
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(4);
        q.enqueue(7);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(6);

        QuickSort.quickSort(q, new DefaultComparator<>());

        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        for (Integer value : expected) {
            assertThat(q.dequeue(), is(equalTo(value)));
        }
    }
    
    @Test
    public void mustOrderUsingInPlaceApproach() {
        Integer[] S = {8, 2, 5, 4, 7, 1, 3, 6};
        
        QuickSort.quickSortInPlace(S, new DefaultComparator<>(), 0, S.length - 1);
        
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(S, is(equalTo(expected)));
    }
}
