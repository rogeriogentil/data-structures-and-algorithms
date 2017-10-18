package rogeriogentil.data.structures.cap8;

import java.util.ArrayList;
import java.util.List;
import rogeriogentil.data.structures.cap7.Position;

/**
 *
 * @author Rogerio J. Gentil
 * @param <E>
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

   @Override
   public Position<E> sibling(Position<E> position) throws IllegalArgumentException {
      Position<E> parent = parent(position);
      
      if (parent == null) {         
         return null;         // p must be the root
      }
      
      if (position == left(parent)) {
         return right(parent);
      }
      
      return left(parent);
   }

   @Override
   public int numChildren(Position<E> position) {
      int count = 0;
      
      if (left(position) != null) {
         count++;
      }
      
      if (right(position) != null) {
         count++;
      }
      
      return count;
   }
   
   @Override
   public Iterable<Position<E>> children(Position<E> position) {
      List<Position<E>> snapshot = new ArrayList<>(2);      // max capacity of 2
      
      if (left(position) != null) {
         snapshot.add(left(position));
      }
      
      if (right(position) != null) {
         snapshot.add(right(position));
      }
      
      return snapshot;
   }
}
