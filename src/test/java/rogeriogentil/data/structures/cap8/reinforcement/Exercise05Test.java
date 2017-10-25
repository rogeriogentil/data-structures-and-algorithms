package rogeriogentil.data.structures.cap8.reinforcement;

import org.junit.Test;
import rogeriogentil.data.structures.cap7.Position;
import rogeriogentil.data.structures.cap8.LinkedBinaryTree;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise05Test {

   @Test
   public void mustReturnZeroWhenBinaryTreeIsEmpty() {
      LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
      int count = Exercise05.countLeftLeaves(linkedBinaryTree, linkedBinaryTree.root());
      assertThat(count, is(equalTo(0)));
   }

   @Test
   public void mustReturnZeroWhenBinaryTreeHasJustRoot() {
      LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
      linkedBinaryTree.addRoot(1);

      int count = Exercise05.countLeftLeaves(linkedBinaryTree, linkedBinaryTree.root());
      assertThat(count, is(equalTo(0)));
   }
   
      @Test
   public void mustReturnZeroWhenBinaryTreeHasJustRightPositions() {
      LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
      linkedBinaryTree.addRoot(1);
      
      Position<Integer> rootRightPosition = linkedBinaryTree.addRight(linkedBinaryTree.root(), 2);
      Position<Integer> rightPositionOfTheRightPosition = linkedBinaryTree.addRight(rootRightPosition, 3);

      int count = Exercise05.countLeftLeaves(linkedBinaryTree, linkedBinaryTree.root());
      assertThat(count, is(equalTo(0)));
   }

   @Test
   public void mustCountLeftLeavesWhenBinaryTreeHasJustOneLeftPosition() {
      LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
      linkedBinaryTree.addRoot(1);

      Position<Integer> rootLeftPosition = linkedBinaryTree.addLeft(linkedBinaryTree.root(), 2);

      int count = Exercise05.countLeftLeaves(linkedBinaryTree, linkedBinaryTree.root());
      assertThat(count, is(equalTo(1)));
   }

   @Test
   public void mustCountLeftLeavesWhenBinaryTreeHasJustLeftmostPosition() {
      LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
      linkedBinaryTree.addRoot(1);

      Position<Integer> rootLeftPosition = linkedBinaryTree.addLeft(linkedBinaryTree.root(), 2);
      Position<Integer> leaveleftPosition = linkedBinaryTree.addLeft(rootLeftPosition, 3);
      
      int count = Exercise05.countLeftLeaves(linkedBinaryTree, linkedBinaryTree.root());
      assertThat(count, is(equalTo(1)));
   }
   
   @Test
   public void mustCountLeftLeavesWhenBinaryTreeHasTwoLeftLeavesPositions() {
      LinkedBinaryTree<Integer> linkedBinaryTree = new LinkedBinaryTree<>();
      linkedBinaryTree.addRoot(1);

      Position<Integer> rootLeftPosition = linkedBinaryTree.addLeft(linkedBinaryTree.root(), 2);
      Position<Integer> leftMostPosition = linkedBinaryTree.addLeft(rootLeftPosition, 3);

      Position<Integer> rootRightPosition = linkedBinaryTree.addRight(linkedBinaryTree.root(), 4);
      Position<Integer> leftPositionOfTheRightPosition = linkedBinaryTree.addLeft(rootRightPosition, 5);
      Position<Integer> rightPositionOfTheRightPosition = linkedBinaryTree.addRight(rootRightPosition, 6);

      int count = Exercise05.countLeftLeaves(linkedBinaryTree, linkedBinaryTree.root());
      assertThat(count, is(equalTo(2)));
   }
}
