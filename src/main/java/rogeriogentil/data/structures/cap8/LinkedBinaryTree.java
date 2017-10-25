package rogeriogentil.data.structures.cap8;

import java.util.Iterator;
import rogeriogentil.data.structures.cap7.Position;

/**
 *
 * @author Rogerio J. Gentil
 * @param <E>
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    protected Node<E> root = null;
    private int size = 0;

    //---------------- nested Node class ----------------
    protected static class Node<E> implements Position<E> {

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E element, Node<E> parent, Node<E> left, Node<E> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return this.element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public void setParent(Node<E> parent) {
            this.parent = parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setRight(Node<E> right) {
            this.right = right;
        }
    }

    /**
     * Factory function to create a new node storing the element
     *
     * @param element
     * @param parent
     * @param left
     * @param right
     * @return
     */
    protected Node<E> creaNode(E element, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node(element, parent, left, right);
    }

    /**
     * Validates the position and returns it as a node.
     *
     * @param position
     * @return
     * @throws IllegalArgumentException
     */
    protected Node<E> validade(Position<E> position) throws IllegalArgumentException {
        if (!(position instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type!");
        }

        Node<E> node = (Node<E>) position;

        if (node.getParent() == node) {         // defined convention for defunct/removed node
            throw new IllegalArgumentException("This position is not longer in the tree");
        }

        return node;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> position) throws IllegalStateException {
        Node<E> node = validade(position);
        return node.getParent();
    }

    @Override
    public Position<E> left(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validade(position);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validade(position);
        return node.getRight();
    }

    /**
     * Places element e at the root of an empty tree and returns its new
     * Position.
     *
     * @param element
     * @return
     * @throws IllegalStateException
     */
    public Position<E> addRoot(E element) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is no empty!");
        }

        root = creaNode(element, null, null, null);
        size = 1;
        return root;
    }

    /**
     * Creates a new left child of Position p storing element e; returns its
     * Position.
     *
     * @param position
     * @param element
     * @return
     * @throws IllegalStateException
     */
    public Position<E> addLeft(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> parent = validade(position);

        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("This position already has a left child!");
        }

        Node<E> child = creaNode(element, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * Creates a new right child of Position p storing element e; returns its
     * Position.
     *
     * @param position
     * @param element
     * @return
     * @throws IllegalStateException
     */
    public Position<E> addRight(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> parent = validade(position);

        if (parent.getRight() != null) {
            throw new IllegalArgumentException("This position already jas a right child!");
        }

        Node<E> right = creaNode(element, parent, null, null);
        parent.setRight(right);
        size++;
        return right;
    }

    /**
     * Replaces the element at Position p with e and returns the replaced
     * element.
     *
     * @param position
     * @param element
     * @return
     */
    public E set(Position<E> position, E element) throws IllegalArgumentException {
        Node<E> node = validade(position);
        E removedElement = node.getElement();
        node.setElement(element);
        return removedElement;
    }

    /**
     * Attaches trees t1 and t2 as left and right subtrees of external position.
     *
     * @param position
     * @param t1
     * @param t2
     */
    public void attach(Position<E> position, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validade(position);

        if (isInternal(position)) {
            throw new IllegalArgumentException("The position must be a leaf!");
        }

        size += t1.size() + t2.size();

        if (!t1.isEmpty()) {            // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }

        if (!t2.isEmpty()) {            // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }

        // TODO: verify why node is not new root!
    }

    /**
     * Removes the node at a position and replaces it with its child, if any.
     *
     * @param position
     * @return
     * @throws IllegalArgumentException
     */
    public E remove(Position<E> position) throws IllegalArgumentException {
        Node<E> node = validade(position);

        if (numChildren(position) == 2) {
            throw new IllegalArgumentException("This position has two children!");
        }

        Node<E> parent = node.getParent();
        Node<E> child = (node.getLeft() != null) ? node.getLeft() : node.getRight();

        if (child != null) {
            child.setParent(parent);
        }

        if (node == root) {
            root = child;
        } else {
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        size--;
        E removedElement = node.getElement();
        node.setElement(null);
        node.setParent(null);
        node.setLeft(null);
        node.setRight(node);            // defined convention to remove node

        return removedElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return preOrder();
    }
    
    // ----- Inner classes -----
//    private class PositionIterator implements Iterator<Position<E>> {
//
//        private Position<E> root = root();
//        
//        @Override
//        public Position<E> next() {
//            if (root == null) {
//                throw new NoSuchElementException("Nothing to get");
//            }
//            
//            return null;
//        }
//        
//        @Override
//        public boolean hasNext() {
//            return next() != null;
//        }
//    }
//
//    private class PositionIterable implements Iterable<Position<E>> {
//
//        @Override
//        public Iterator<Position<E>> iterator() {
//            return new PositionIterator();
//        }
//    }

    /**
     * This class adapts the iteration produced by positions() to return elements.
     */
    private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> positionIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }
        
        @Override
        public void remove() {
            positionIterator.remove();
        }
    }
}
