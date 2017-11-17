package rogeriogentil.data.structures.chapter08;

import java.util.ArrayList;
import java.util.List;
import rogeriogentil.data.structures.chapter06.LinkedQueue;
import rogeriogentil.data.structures.chapter06.Queue;
import rogeriogentil.data.structures.chapter07.Position;

/**
 *
 * @author Rogerio J. Gentil
 * @param <E>
 */
public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    public boolean isInternal(Position<E> position) throws IllegalStateException {
        return numChildren(position) > 0;
    }

    @Override
    public boolean isExternal(Position<E> position) throws IllegalStateException {
        return numChildren(position) == 0;
    }

    @Override
    public boolean isRoot(Position<E> position) throws IllegalStateException {
        return position == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> position) {
        if (isRoot(position)) {
            return 0;
        }

        return 1 + depth(parent(position));
    }

    /**
     * Returns the height of the subtree rooted at Position p.
     *
     * @param position
     * @return
     */
    public int height(Position<E> position) {
        int height = 0;

        for (Position<E> child : children(position)) {
            height = Math.max(height, 1 + height(child));
        }

        return height;
    }

    /**
     * Returns the height of the tree.
     *
     * @return
     */
    private int heightBad() {     // works, but quadratic worst-case time
        int height = 0;
        for (Position<E> position : positions()) {
            if (isExternal(position)) {
                height = Math.max(height, depth(position));
            }
        }

        return height;
    }

    /**
     * Adds positions of the subtree rooted at position to the given snapshot.
     * 
     * @param position
     * @param snapshot
     */
    private void preOrderSubtree(Position<E> position, List<Position<E>> snapshot) {
        snapshot.add(position);         // for preorder, we add position before exploring subtrees
        
        for (Position<E> child : children(position)) {
            preOrderSubtree(child, snapshot);
        }
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in preorder.
     * 
     * @return 
     */
    public Iterable<Position<E>> preOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preOrderSubtree(root(), snapshot);
        }
        
        return snapshot;
    }
    
    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     * @param position
     * @param snapshot 
     */
    private void postOrderSubtree(Position<E> position, List<Position<E>> snapshot) {
        for (Position<E> child : children(position)) {
            postOrderSubtree(child, snapshot);
        }
        
        snapshot.add(position);         // for preorder, we add position before exploring subtrees
    }
    
    public Iterable<Position<E>> postOrder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postOrderSubtree(root(), snapshot);
        }
        
        return snapshot;
    }
    
    /**
     * Returns an iterable collection of positions of the tree in breadth-first order.
     * 
     * @return 
     */
    public Iterable<Position<E>> breathFirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root());
            
            while (!fringe.isEmpty()) {
                Position<E> position = fringe.dequeue();
                snapshot.add(position);
                
                for (Position<E> child : children(position)) {
                    fringe.enqueue(child);
                }
            }
        }
        
        return snapshot;
    }
}
