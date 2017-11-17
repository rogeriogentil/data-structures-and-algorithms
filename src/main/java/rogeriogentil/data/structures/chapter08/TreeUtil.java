package rogeriogentil.data.structures.chapter08;

import java.util.List;
import rogeriogentil.data.structures.chapter07.Position;

/**
 *
 * @author Rogerio J. Gentil
 */
public class TreeUtil {

   /**
    * Prints preorder representation of subtree of a tree rooted at a position having a depth.
    *
    * @param <E>
    * @param tree
    * @param position
    * @param depth
    */
   public static <E> void printPreOrderIndent(Tree<E> tree, Position<E> position, int depth) {
      System.out.println(spaces(2 * depth) + position.getElement());

      for (Position<E> child : tree.children(position)) {
         printPreOrderIndent(tree, child, depth + 1);    // child depth is d+1
      }
   }

   /**
    * Prints labeled representation of subtree of the tree rooted at a position having a depth.
    * 
    * @param <E>
    * @param tree
    * @param position
    * @param path 
    */
   public static <E> void printPreOrderLabeled(Tree<E> tree, Position<E> position, List<Integer> path) {
      int depth = path.size();      // depth equals the length of the path
      System.out.print(spaces(2 * depth));

      for (int j = 0; j < depth; j++) {
         System.out.print(path.get(j) + (j == depth - 1 ? " " : "."));
      }

      System.out.println(position.getElement());

      path.add(1);                 // add path entry for first child

      for (Position<E> child : tree.children(position)) {
         printPreOrderLabeled(tree, child, path);
         path.set(depth, 1 + path.get(depth));     // increment last entry of path
      }
      
      path.remove(depth);
   }
   
   /**
    * Prints parenthesized representation of subtree of the tree rooted at a position
    * 
    * @param <E>
    * @param tree
    * @param position 
    */
   public static <E> void paranthesize(Tree<E> tree, Position<E> position) {
      System.out.println(position.getElement());
      
      if (tree.isInternal(position)) {
         boolean firstTime = true;
         
         for (Position<E> child : tree.children(position)) {
            System.out.println(firstTime ? "(" : ", ");
            firstTime = false;
            paranthesize(tree, child);
         }
         
         System.out.println(")");
      }
   }

   private static String spaces(int n) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < n; i++) {
         sb.append(" ");
      }
      return sb.toString();
   }

   /**
    * Recursive method for computing coordinates at which to draw positions of a binary tree. We assume that the element 
    * type for the tree supports setX and setY methods. The initial call should be layout(T, T.root( ), 0, 0).
    * 
    * @param <E>
    * @param binaryTree
    * @param position
    * @param depth
    * @param x
    * @return 
    */
//   public static <E> int layout(BinaryTree<E> binaryTree, Position<E> position, int depth, int x) {
//      if (binaryTree.left(position) != null) {
//         x = layout(binaryTree, binaryTree.left(position), depth + 1, x);   // resulting x will be increased
//      }
//      
//      position.getElement().setX(x++);
//      position.getElement().setY(depth);
//      
//      if (binaryTree.right(position) != null) {
//         x = layout(binaryTree, binaryTree.right(position), depth + 1, x);    // resulting x will be increased
//      }
//      
//      return x;
//   }
}
