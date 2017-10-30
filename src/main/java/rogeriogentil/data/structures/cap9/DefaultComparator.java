package rogeriogentil.data.structures.cap9;

import java.util.Comparator;

/**
 *
 * @author Rogerio J. Gentil
 */
public class DefaultComparator<E> implements Comparator<E> {

   @Override
   public int compare(E a, E b) throws ClassCastException {
      return ((Comparable<E>) a).compareTo(b);
   }
}
