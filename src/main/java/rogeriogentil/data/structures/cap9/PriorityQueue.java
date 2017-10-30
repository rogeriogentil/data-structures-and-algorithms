package rogeriogentil.data.structures.cap9;

/**
 * Interface for the priority queue ADT.
 *
 * @author Rogerio J. Gentil
 * @param <K>
 * @param <V>
 */
public interface PriorityQueue<K, V> {

   int size();

   boolean isEmpty();

   Entry<K, V> insert(K key, V value) throws IllegalArgumentException;

   Entry<K, V> min();

   Entry<K, V> removeMin();
}
