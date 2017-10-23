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
   
   /**
    * Adds positions of the subtree rooted at a position to the given snapshot.
    * 
    * @param position
    * @param snapshot 
    */
   private void inOrderSubtree(Position<E> position, List<Position<E>> snapshot) {
       if (left(position) != null) {
           inOrderSubtree(left(position), snapshot);
       }
       
       snapshot.add(position);
       
       if (right(position) != null) {
           inOrderSubtree(right(position), snapshot);
       }
   }
   
   /**
    * Returns an iterable collection of positions of the tree, reported in inorder.
    * 
    * @return 
    */
   public Iterable<Position<E>> inOrder() {
       List<Position<E>> snapshot = new ArrayList<>();
       
       if (!isEmpty()) {
           inOrderSubtree(root(), snapshot);    // fill the snapshot recursively
       }
       
       return snapshot;
   }
   
   @Override
   public Iterable<Position<E>> positions() {
       return inOrder();
   }
}
