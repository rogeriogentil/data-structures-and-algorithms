package rogeriogentil.data.structures.chapter09;

/**
 *
 * @author Rogerio J. Gentil
 */
interface AdaptablePriorityQueue<K, V> {

    void remove(Entry<K, V> entry);
    
    void replaceKey(Entry<K, V> entry, K key);
    
    void replaceValue(Entry<K, V> entry, V value);
}
