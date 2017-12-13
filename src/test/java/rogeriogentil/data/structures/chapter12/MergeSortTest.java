package rogeriogentil.data.structures.chapter12;


import org.junit.Test;
import rogeriogentil.data.structures.chapter09.DefaultComparator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import rogeriogentil.data.structures.chapter06.LinkedQueue;
import rogeriogentil.data.structures.chapter06.Queue;

/**
 *
 * @author Rogerio J. Gentil
 */
public class MergeSortTest {

    @Test
    public void mustOrderDataUsingArrayBasedApproach() {
        System.out.println("Testing Array-based mergeSort implementation");
        Integer[] s = {2, 6, 9, 7, 5, 3, 1, 4, 8};
        MergeSort.mergeSort(s, new DefaultComparator<>());
        
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(s, is(equalTo(expected)));
    }
    
    @Test
    public void mustOrderDataUsingQueueApproach() {
        System.out.println("Testing Queue-based mergeSort implementation");
        Queue<Integer> S = new LinkedQueue<>();
        S.enqueue(2);
        S.enqueue(6);
        S.enqueue(9);
        S.enqueue(7);
        S.enqueue(5);
        S.enqueue(3);
        S.enqueue(1);
        S.enqueue(4);
        S.enqueue(8);
                
        MergeSort.mergeSort(S, new DefaultComparator<>());
        
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        for (Integer value : expected) {
            assertThat(S.dequeue(), is(equalTo(value)));
        }
    }

    @Test
    public void mustOrderDataUsingBottomUpApproach() {
        System.out.println("Testing Bottom-Up mergeSort implementation");
        Integer[] s = {2, 6, 9, 7, 5, 3, 1, 4, 8};
        MergeSort.mergeSortBottomUp(s, new DefaultComparator<>());
        
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(s, is(equalTo(expected)));
    }
}
