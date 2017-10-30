package rogeriogentil.data.structures.cap9;

import java.util.Comparator;
import rogeriogentil.data.structures.cap7.LinkedPositionalList;
import rogeriogentil.data.structures.cap7.Position;
import rogeriogentil.data.structures.cap7.PositionalList;

/**
 *
 * @author Rogerio J. Gentil
 */
public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

   private LinkedPositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

   public SortedPriorityQueue() {
   }

   public SortedPriorityQueue(Comparator<K> c) {
      super(c);
   }

   @Override
   public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
      if (!checkKey(key)) {
         throw new IllegalArgumentException();
      }
      
      Entry<K, V> newest = new PQEntry<>(key, value);
      
      Position<Entry<K, V>> walk = list.last();
      
      while (walk != null && compare(newest, walk.getElement()) < 0) {
         walk = list.before(walk);
         
         if (walk == null) {
            list.addFirst(newest);
         } else {
            list.addAfter(walk, newest);
         }
      }
      
      return newest;
   }

   @Override
   public Entry<K, V> min() {
      if (list.isEmpty()) {
         return null;
      }
      
      return list.first().getElement();
   }

   @Override
   public Entry<K, V> removeMin() {
      if (list.isEmpty()) {
         return null;
      }
      
      return list.remove(list.first());
   }

   @Override
   public int size() {
      return list.size();
   }
}
