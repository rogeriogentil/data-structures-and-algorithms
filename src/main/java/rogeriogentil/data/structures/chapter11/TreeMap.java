package rogeriogentil.data.structures.chapter11;

import java.util.ArrayList;
import java.util.Comparator;
import rogeriogentil.data.structures.chapter07.Position;
import rogeriogentil.data.structures.chapter08.LinkedBinaryTree;
import rogeriogentil.data.structures.chapter09.Entry;
import rogeriogentil.data.structures.chapter10.AbstractSortedMap;

/**
 * An implementation of a sorted map using a binary search tree
 *
 * @author Rogerio J. Gentil
 * @param <K> Key
 * @param <V> Value
 */
public class TreeMap<K, V> extends AbstractSortedMap<K, V> {

    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

    public TreeMap() {
        super();
        tree.addRoot(null);
    }

    public TreeMap(Comparator<K> comp) {
        super(comp);
        tree.addRoot(null);
    }

    @Override
    public int size() {
        return (tree.size() - 1) / 2;   // only internal nodes have entries
    }

    /**
     * Utility used when inserting a new entry at a leaf of the tree.
     *
     * @param position
     * @param entry
     */
    private void expandExternal(Position<Entry<K, V>> position, Entry<K, V> entry) {
        tree.set(position, entry);

        // add new sentinel leaves as children
        tree.addLeft(position, null);
        tree.addRight(position, null);
    }

    protected Position<Entry<K, V>> root() {
        return tree.root();
    }

    protected Position<Entry<K, V>> parent(Position<Entry<K, V>> p) {
        return tree.parent(p);
    }

    protected Position<Entry<K, V>> left(Position<Entry<K, V>> p) {
        return tree.left(p);
    }

    protected Position<Entry<K, V>> right(Position<Entry<K, V>> p) {
        return tree.right(p);
    }

    protected Position<Entry<K, V>> sibling(Position<Entry<K, V>> p) {
        return tree.sibling(p);
    }

    protected boolean isRoot(Position<Entry<K, V>> p) {
        return tree.isRoot(p);
    }

    protected boolean isExternal(Position<Entry<K, V>> p) {
        return tree.isExternal(p);
    }

    protected boolean isInternal(Position<Entry<K, V>> p) {
        return tree.isInternal(p);
    }

    protected void set(Position<Entry<K, V>> p, Entry<K, V> e) {
        tree.set(p, e);
    }

    protected Entry<K, V> remove(Position<Entry<K, V>> p) {
        return tree.remove(p);
    }

    protected void rotate(Position<Entry<K, V>> p) {
        tree.rotate(p);
    }

    protected Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
        return tree.restructure(x);
    }

    /**
     * Returns the position in p's subtree having given key (or else the
     * terminal leaf)
     *
     * @param position
     * @param key
     * @return
     */
    private Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> position, K key) {
        if (isExternal(position)) {
            return position;         // key not found; return the final leaf
        }

        int comp = compare(key, position.getElement());
        if (comp == 0) {
            return position;                         // key found; return its position
        } else if (comp < 0) {
            return treeSearch(left(position), key);  // search left subtree
        } else {
            return treeSearch(right(position), key); // search right subtree
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);
        rebalanceAccess(position);

        if (isExternal(position)) {
            return null;
        }

        return position.getElement().getvalue();
    }

    /**
     * Associates the given value with the given key, returning any overridden
     * value.
     *
     * @param key
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public V put(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newEntry = new MapEntry<>(key, value);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isExternal(position)) {             // key is new
            expandExternal(position, newEntry);
            rebalanceInsert(position);         // hook for balanced tree subclasses
            return null;
        } else {                                // replacing existing key
            V old = position.getElement().getvalue();
            set(position, newEntry);
            rebalanceAccess(position);         // hook for balanced tree subclasses
            return old;
        }
    }

    /**
     * Removes the entry having key k (if any) and returns its associated value.
     *
     * @param key
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isExternal(position)) {             // key not found
            rebalanceAccess(position);          // hook for balanced tree subclasses
            return null;
        } else {
            V old = position.getElement().getvalue();

            // both children are internal
            if (isInternal(left(position)) && isExternal(right(position))) {
                Position<Entry<K, V>> replacement = treeMax(left(position));
                set(position, replacement.getElement());
                position = replacement;
            } // now p has at most one child that is an internal node

            Position<Entry<K, V>> leaf = isExternal(left(position)) ? left(position) : right(position);
            Position<Entry<K, V>> sibling = sibling(leaf);
            remove(leaf);
            remove(position);               // sibling is promoted in p’s place
            rebalanceDelete(sibling);      // hook for balanced tree subclasses
            return old;
        }
    }

    /**
     * Returns the position with the maximum key in subtree rooted.
     *
     * @param position
     * @return
     */
    protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> position) {
        Position<Entry<K, V>> walk = position;
        while (isInternal(walk)) {
            walk = right(walk);
        }

        return parent(walk);            // we want the parent of the leaf
    }

    /**
     * Returns the entry having the greatest key (or null if map is empty).
     *
     * @return
     */
    @Override
    public Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }

        return treeMax(root()).getElement();
    }

    /**
     * Returns the entry with greatest key less than or equal to given key (if
     * any).
     *
     * @param key
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isInternal(position)) {         // exact match
            return position.getElement();
        }

        while (!isRoot(position)) {
            if (position == right(parent(position))) {
                return parent(position).getElement();   // parent has next lesser key
            } else {
                position = parent(position);
            }
        }

        return null;
    }

    @Override
    public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> position = treeSearch(root(), key);

        if (isInternal(position) && isInternal(left(position))) {
            return treeMax(left(position)).getElement();        // this is the predecessor to p
        }

        // otherwise, we had failed search, or match with no left child
        while (!isRoot(position)) {
            if (position == right(parent(position))) {
                return parent(position).getElement();   // parent has next lesser key
            } else {
                position = parent(position);
            }
        }

        return null;            // no such lesser key exists
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());

        for (Position<Entry<K, V>> position : tree.inOrder()) {
            if (isInternal(position)) {
                buffer.add(position.getElement());
            }
        }

        return buffer;
    }

    /**
     * Returns an iterable of entries with keys in range [fromKey, toKey).
     *
     * @param fromKey
     * @param toKey
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(size());

        if (compare(fromKey, toKey) < 0) {                  // ensure that fromKey < toKey
            subMapRecurse(fromKey, toKey, root(), buffer);
        }

        return buffer;
    }

    /**
     *
     * @param fromKey
     * @param toKey
     * @param position
     * @param buffer
     */
    private void subMapRecurse(K fromKey, K toKey, Position<Entry<K, V>> position, ArrayList<Entry<K, V>> buffer) {
        if (isInternal(position)) {
            if (compare(position.getElement(), fromKey) < 0) {
                // p's key is less than fromKey, so any relevant entries are to the right
                subMapRecurse(fromKey, toKey, right(position), buffer);
            } else {
                subMapRecurse(fromKey, toKey, left(position), buffer);           // first consider left subtree
                if (compare(position.getElement(), toKey) < 0) {                // p is within range
                    buffer.add(position.getElement());                          // so add it to buffer, and consider
                    subMapRecurse(fromKey, toKey, right(position), buffer);      // right subtree as well    
                }
            }
        }
    }

    /**
     * Returns position with the minimal key in the subtree rooted at Position
     * p.
     *
     * @param p a Position of the tree serving as root of a subtree
     * @return Position with minimal key in subtree
     */
    protected Position<Entry<K, V>> treeMin(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> walk = p;
        while (isInternal(walk)) {
            walk = left(walk);
        }
        return parent(walk);              // we want the parent of the leaf
    }

    // additional behaviors of the SortedMap interface
    /**
     * Returns the entry having the least key (or null if map is empty).
     *
     * @return entry with least key (or null if map is empty)
     */
    @Override
    public Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return treeMin(root()).getElement();
    }

    /**
     * Returns the entry with least key greater than or equal to given key (or
     * null if no such key exists).
     *
     * @return entry with least key greater than or equal to given (or null if
     * no such entry)
     * @throws IllegalArgumentException if the key is not compatible with the
     * map
     */
    @Override
    public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
        checkKey(key);                              // may throw IllegalArgumentException
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isInternal(p)) {
            return p.getElement();   // exact match
        }
        while (!isRoot(p)) {
            if (p == left(parent(p))) {
                return parent(p).getElement();          // parent has next greater key
            } else {
                p = parent(p);
            }
        }
        return null;                                // no such ceiling exists
    }

    /**
     * Returns the entry with least key strictly greater than given key (or null
     * if no such key exists).
     *
     * @return entry with least key strictly greater than given (or null if no
     * such entry)
     * @throws IllegalArgumentException if the key is not compatible with the
     * map
     */
    @Override
    public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
        checkKey(key);                               // may throw IllegalArgumentException
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isInternal(p) && isInternal(right(p))) {
            return treeMin(right(p)).getElement();     // this is the successor to p
        }    // otherwise, we had failed search, or match with no right child
        while (!isRoot(p)) {
            if (p == left(parent(p))) {
                return parent(p).getElement();           // parent has next lesser key
            } else {
                p = parent(p);
            }
        }
        return null;                                 // no such greater key exists
    }

    // Stubs for balanced search tree operations (subclasses can override)
    /**
     * Rebalances the tree after an insertion of specified position. This
     * version of the method does not do anything, but it can be overridden by
     * subclasses.
     *
     * @param p the position which was recently inserted
     */
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
    }

    /**
     * Rebalances the tree after a child of specified position has been removed.
     * This version of the method does not do anything, but it can be overridden
     * by subclasses.
     *
     * @param p the position of the sibling of the removed leaf
     */
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
    }

    /**
     * Rebalances the tree after an access of specified position. This version
     * of the method does not do anything, but it can be overridden by a
     * subclasses.
     *
     * @param p the Position which was recently accessed (possibly a leaf)
     */
    protected void rebalanceAccess(Position<Entry<K, V>> p) {
    }

    // -------- Nested class --------
    /**
     * A specialized version of LinkedBinaryTree with support for balancing.
     *
     * @param <K> Key
     * @param <V> Value
     */
    protected static class BalanceableBinaryTree<K, V> extends LinkedBinaryTree<Entry<K, V>> {

        //-------------- nested BSTNode class --------------
        // this extends the inherited LinkedBinaryTree.Node class
        protected static class BSTNode<E> extends Node<E> {

            int aux = 0;

            BSTNode(E element, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
                super(element, parent, leftChild, rightChild);
            }

            public int getAux() {
                return aux;
            }

            public void setAux(int aux) {
                this.aux = aux;
            }
        } //--------- end of nested BSTNode class ---------

        // positional-based methods related to aux field
        public int getAux(Position<Entry<K, V>> position) {
            return ((BSTNode<Entry<K, V>>) position).getAux();
        }

        public void setAux(Position<Entry<K, V>> position, int value) {
            ((BSTNode<Entry<K, V>>) position).setAux(value);
        }

        // Override node factory function to produce a BSTNode (rather than a Node)
        @Override
        protected Node<Entry<K, V>> creaNode(Entry<K, V> element,
                Node<Entry<K, V>> parent, Node<Entry<K, V>> left, Node<Entry<K, V>> right) {
            return new BSTNode<>(element, parent, left, right);
        }

        /**
         * Relinks a parent node with its oriented child node.
         *
         * @param parent
         * @param child
         * @param makeLeftChild
         */
        private void relink(Node<Entry<K, V>> parent, Node<Entry<K, V>> child, boolean makeLeftChild) {
            child.setParent(parent);

            if (makeLeftChild) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }

        /**
         * Rotates a position above its parent.
         *
         * @param position
         */
        public void rotate(Position<Entry<K, V>> position) {
            Node<Entry<K, V>> x = validade(position);
            Node<Entry<K, V>> y = x.getParent();        // we assume this exists
            Node<Entry<K, V>> z = y.getParent();        // grandparent (possibly null)

            if (z == null) {
                root = x;                               // x becomes root of the tree
                x.setParent(null);
            } else {
                boolean makeLeftChild = y == z.getLeft();
                relink(z, x, makeLeftChild);            // x becomes direct child of z
            }

            // now rotate x and y, including transfer of middle subtree
            if (x == y.getLeft()) {
                relink(y, x.getRight(), true);          // x’s right child becomes y’s left
                relink(x, y, false);                    // y becomes x’s right child
            } else {
                relink(y, x.getLeft(), false);          // x’s left child becomes y’s right
                relink(x, y, true);                     // y becomes left child of x
            }
        }

        /**
         * Performs a trinode restructuring of Position x with its
         * parent/grandparent.
         *
         * @param x
         * @return
         */
        public Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
            Position<Entry<K, V>> y = parent(x);
            Position<Entry<K, V>> z = parent(y);

            if ((x == right(y)) == (y == right(z))) {   // matching alignments
                rotate(y);                              // single rotation (of y)
                return y;                               // y is new subtree root
            } else {                                    // opposite alignments
                // double rotation (of x)
                rotate(x);
                rotate(x);
                return x;                               // x is new subtree root
            }
        }
    }
}
