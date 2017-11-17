package rogeriogentil.data.structures.chapter09;

/**
 * Interface for a key-value pair
 *
 * @author Rogerio J. Gentil
 * @param <K> key
 * @param <V> value
 */
public interface Entry<K, V> {

   /**
    * Returns the key stored in this entry
    *
    * @return
    */
   K getKey();

   /**
    * Returns the value stored in this entry
    *
    * @return
    */
   V getvalue();
}
