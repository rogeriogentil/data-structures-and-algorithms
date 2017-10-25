package rogeriogentil.data.structures.cap8.reinforcement;

import rogeriogentil.data.structures.cap7.Position;
import rogeriogentil.data.structures.cap8.BinaryTree;

/**
 * R-8.5 Describe an algorithm, relying only on the BinaryTree operations, that counts the number of leaves in a binary
 * tree that are the left child of their respective parent.
 *
 * @author Rogerio J. Gentil
 */
public class Exercise05 {

   public static <E> int countLeftLeaves(BinaryTree<E> binaryTree, Position<E> position) {
      int count = 0;
      
      if (binaryTree.isEmpty() || binaryTree.size() == 1) {
         return count;
      }

      Position<E> parent = binaryTree.parent(position);

      if (binaryTree.isExternal(position) && binaryTree.left(parent) == position) {
         return count + 1;
      } else {
         if (binaryTree.left(position) != null) {
            count += countLeftLeaves(binaryTree, binaryTree.left(position));
         }

         if (binaryTree.right(position) != null) {
            count += countLeftLeaves(binaryTree, binaryTree.right(position));
         }

      }

      return count;
   }
}
