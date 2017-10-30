package rogeriogentil.data.structures.cap9;

/**
 * Interface for a key-value pair
 *
 * @author Rogerio J. Gentil
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
