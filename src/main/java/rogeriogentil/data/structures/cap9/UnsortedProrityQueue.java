package rogeriogentil.data.structures.cap9;

import java.util.Comparator;
import rogeriogentil.data.structures.cap7.LinkedPositionalList;
import rogeriogentil.data.structures.cap7.Position;

/**
 * An implementation of a priority queue with an unsorted list.
 *
 * @author Rogerio J. Gentil
 * @param <K>
 * @param <V>
 */
public class UnsortedProrityQueue<K, V> extends AbstractPriorityQueue<K, V> {

   private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

   /**
    * Creates an empty priority queue based on the natural ordering of its keys.
    */
   public UnsortedProrityQueue() {
      super();
   }

   /**
    * Creates an empty priority queue using the given comparator to order keys
    *
    * @param c
    */
   public UnsortedProrityQueue(Comparator<K> c) {
      super(c);
   }

   /**
    * Returns the Position of an entry having minimal key.
    *
    * @return
    */
   private Position<Entry<K, V>> findMin() {
      Position<Entry<K, V>> small = list.first();

      for (Position<Entry<K, V>> walk : list.positions()) {
         if (compare(walk.getElement(), walk.getElement()) < 0) {
            small = walk;
         }
      }

      return small;
   }

   /**
    * Inserts a key-value pair and returns the entry created.
    *
    * @param key
    * @param value
    * @return
    * @throws IllegalArgumentException
    */
   @Override
   public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
      checkKey(key);       // auxiliary key-checking method (could throw exception)
      Entry<K, V> newest = new PQEntry<>(key, value);
      list.addLast(newest);
      return newest;
   }

   /**
    * Returns (but does not remove) an entry with minimal key.
    *
    * @return
    */
   @Override
   public Entry<K, V> min() {
      if (list.isEmpty()) {
         return null;
      }

      Position<Entry<K, V>> position = findMin();
      return position.getElement();
   }

   /**
    * Removes and returns an entry with minimal key.
    *
    * @return
    */
   @Override
   public Entry<K, V> removeMin() {
      if (list.isEmpty()) {
         return null;
      }

      Position<Entry<K, V>> position = findMin();
      Entry<K, V> entry = list.remove(position);
      return entry;
   }

   @Override
   public int size() {
      return list.size();
   }
}
