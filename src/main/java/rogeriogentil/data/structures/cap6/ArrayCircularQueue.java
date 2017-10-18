package rogeriogentil.data.structures.cap6;

/**
 *
 * @author rogerio
 */
public class ArrayCircularQueue<E> implements Queue<E> {
   
   private static final int CAPACITY = 1000;
   private int front;
   private int storedSize;
   private E[] array;

   public ArrayCircularQueue() {
      this(CAPACITY);
   }
   
   public ArrayCircularQueue(final int capacity) {
      array = (E[]) new Object[capacity];
   }
   
   @Override
   public void enqueue(E element) {
      if (this.storedSize == this.array.length) {
         throw new IllegalStateException("Queue is full!");
      }
      
      int avail = (this.front + this.storedSize) % array.length;
      array[avail] = element;
      this.storedSize++;
   }

   @Override
   public E dequeue() {
      if (isEmpty()) {
         return null;
      }
      
      E element = first();
      array[front] = null;
      this.front = (this.front + 1) % array.length;
      this.storedSize--;
      return element;
   }

   @Override
   public int size() {
      return this.storedSize;
   }
   
   @Override
   public boolean isEmpty() {
      return this.storedSize == 0;
   }
   
   @Override
   public E first() {
      if (isEmpty()) {
         return null;
      }
      
      return array[front];
   }

}
