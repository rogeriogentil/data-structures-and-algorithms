package rogeriogentil.data.structures.chapter09;

import rogeriogentil.data.structures.chapter07.PositionalList;

/**
 *
 * @author Rogerio J. Gentil
 * @param <E>
 */
public class PriorityQueueUtils<E> {

    /**
     * Sorts sequence using initially empty priority queue to produce the order.
     *
     * @param <E>
     * @param sequence
     * @param priorityQueue
     */
    public static <E> void pqSort(PositionalList<E> sequence, PriorityQueue<E, ?> priorityQueue) {
        int n = sequence.size();
        
        for (int i = 0; i < n; i++) {
            E element = sequence.remove(sequence.first());
            priorityQueue.insert(element, null);    // element is key; null value
        }
 
        for (int i = 0; i < n; i++) {
            E element = priorityQueue.removeMin().getKey();
            sequence.addLast(element);  // the smallest key in Priority Queye is next placed in Sequence
        }
    }
}
