package rogeriogentil.data.structures.cap7.reinforcement;

import rogeriogentil.data.structures.cap6.Stack;
import rogeriogentil.data.structures.cap7.ArrayList;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise02 {
}

/**
 * R-7.2 Give an implementation of the stack ADT using an array list for storage.
 */
class StackArrayList<E> implements Stack<E> {

   private static final int CAPACITY = 16;
   private ArrayList<E> data;

   public StackArrayList(final int capacity) {
      data = new ArrayList<>(capacity);
   }

   public StackArrayList() {
      this(CAPACITY);
   }

   @Override
   public E top() {
      return data.get(this.size() - 1);
   }

   @Override
   public E pop() {
      return data.remove(this.size() - 1);
   }

   @Override
   public void push(E element) {
      data.add(size(), element);
   }

   @Override
   public boolean isEmpty() {
      return this.data.size() == 0;
   }

   @Override
   public int size() {
      return this.data.size();
   }
}
