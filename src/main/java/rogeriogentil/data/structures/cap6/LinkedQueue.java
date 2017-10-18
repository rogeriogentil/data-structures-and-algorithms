package rogeriogentil.data.structures.cap6;

import rogeriogentil.data.structures.cap3.SinglyLinkedList;
import rogeriogentil.data.structures.cap6.Queue;

/**
 *
 * @author rogerio
 */
public class LinkedQueue<E> implements Queue<E> {

   private SinglyLinkedList<E> list = new SinglyLinkedList<>();

   @Override
   public void enqueue(E element) {
      list.addLast(element);
   }

   @Override
   public E dequeue() {
      return list.removeFist();
   }

   @Override
   public E first() {
      return list.first();
   }

   @Override
   public int size() {
      return list.getSize();
   }

   @Override
   public boolean isEmpty() {
      return list.isEmpty();
   }

}
