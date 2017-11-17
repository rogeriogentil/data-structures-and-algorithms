package rogeriogentil.data.structures.chapter06;

/**
 *
 * @author rogerio
 */
public interface Queue<E> {
   
   /**
    * Adds element e to the back of queue.
    * @param e 
    */
   void enqueue(E element);
   
   /**
    * Removes and returns the first element from the queue (or null if the queue is empty).
    * @return E
    */
   E dequeue();
   
   /**
    * Returns the first element of the queue, without removing it (or null if the queue is empty).
    * @return The first element of the queue
    */
   E first();
   
   /**
    * Returns the number of elements in the queue.
    * @return 
    */
   int size();
   
   /**
    * Returns a boolean indicating whether the queue is empty.
    * @return {@code true} or {@code false}
    */
   boolean isEmpty();
}
