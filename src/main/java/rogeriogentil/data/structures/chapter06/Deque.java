package rogeriogentil.data.structures.chapter06;

/**
 *
 * @author Rogerio J. Gentil
 * @param <E>
 */
public interface Deque<E> {

   /**
    * Inserts an element at the front of the deque.
    * @param element 
    */
   void addFirst(E element);
   
   /**
    * Inserts an element at the back of the deque.
    * @param element 
    */
   void addLast(E element);
   
   /**
    * Removes and returns the first element of the deque (null if empty).
    * @return 
    */
   E removeFirst();
   
   /**
    * Removes and returns the last element of the deque (null if empty).
    * @return 
    */
   E removeLast();
   
   /**
    * Returns, but does not remove, the first element of the deque (null if empty).
    * @return 
    */
   E first();
   
   /**
    * Returns, but does not remove, the last element of the deque (null if empty).
    * @return 
    */
   E last();
   
   /**
    * Returns the number of elements in the deque.
    * @return 
    */
   int size();
   
   /**
    * Tests whether the deque is empty.
    * @return {@code true} or {@code false}
    */
   boolean isEmpty();
}
