package rogeriogentil.data.structures.chapter06.reinforcement;

import rogeriogentil.data.structures.chapter06.Deque;
import rogeriogentil.data.structures.chapter06.DoublyLinkedList;
import rogeriogentil.data.structures.chapter06.Stack;

/**
 * R-6.10 Give a simple adapter that implements the stack ADT while using an instance of a deque for storage.
 * 
 * @author Rogerio J. Gentil
 * @param <E>
 */
public class Exercise10<E> implements Stack<E> {

   private Deque<E> deque;

   public Exercise10() {
      this.deque = new DoublyLinkedList<>();
   }
   
   @Override
   public void push(E e) {
      this.deque.addLast(e);
   }

   @Override
   public E pop() {
      return this.deque.removeLast();
   }

   @Override
   public E top() {
      return this.deque.last();
   }

   @Override
   public int size() {
      return this.deque.size();
   }

   @Override
   public boolean isEmpty() {
      return this.deque.isEmpty();
   }
}
