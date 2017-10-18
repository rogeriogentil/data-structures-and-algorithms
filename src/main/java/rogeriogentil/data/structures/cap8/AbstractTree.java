package rogeriogentil.data.structures.cap8;

import rogeriogentil.data.structures.cap7.Position;

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

}
