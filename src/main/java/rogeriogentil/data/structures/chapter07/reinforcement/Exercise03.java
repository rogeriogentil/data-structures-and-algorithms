package rogeriogentil.data.structures.chapter07.reinforcement;

import rogeriogentil.data.structures.chapter06.Deque;
import rogeriogentil.data.structures.chapter07.ArrayList;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise03 {
}

/**
 * R-7.3 Give an implementation of the deque ADT using an array list for storage.
 * 
 * @author rogerio
 */
class DequeArrayList<E> implements Deque<E> {
   
   private static final int CAPACITY = 32;
   private ArrayList<E> data;

   public DequeArrayList(final int capacity) {
      data = new ArrayList<>(capacity);
   }
   
   public DequeArrayList() {
      this(CAPACITY);
   }

   @Override
   public void addFirst(E element) {
      this.data.add(0, element);
   }

   @Override
   public void addLast(E element) {
      this.data.add(this.data.size(), element);
   }

   @Override
   public E removeFirst() {
      return this.data.remove(0);
   }

   @Override
   public E removeLast() {
      return this.data.remove(this.data.size() - 1);
   }

   @Override
   public E first() {
      return this.data.get(0);
   }

   @Override
   public E last() {
      return this.data.get(this.data.size() - 1);
   }

   @Override
   public int size() {
      return this.data.size();
   }

   @Override
   public boolean isEmpty() {
      return this.data.size() == 0;
   }
   
}