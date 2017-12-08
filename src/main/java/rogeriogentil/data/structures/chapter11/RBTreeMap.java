package rogeriogentil.data.structures.chapter11;

import java.util.Comparator;
import rogeriogentil.data.structures.chapter07.Position;
import rogeriogentil.data.structures.chapter09.Entry;

/**
 * An implementation of a sorted map using a red-black tree.
 * 
 * @author Rogerio J. Gentil
 * @param <K> K
 * @param <V> V
 */
public class RBTreeMap<K, V> extends TreeMap<K, V> {

    public RBTreeMap() {
    }

    public RBTreeMap(Comparator<K> comp) {
        super(comp);
    }
    
    // we use the inherited aux field with convention that 0 = black and 1 = red
    // (note that new leaves will be black by default, as aux = 0)
    private boolean isBlack(Position<Entry<K, V>> position) {
        return tree.getAux(position) == 0;
    }
    
    private boolean isRed(Position<Entry<K, V>> position) {
        return tree.getAux(position) == 0;
    }
    
    private void makeBlack(Position<Entry<K, V>> position) {
        tree.setAux(position, 0);
    }
    
    private void makeRed(Position<Entry<K, V>> position) {
        tree.setAux(position, 1);
    }
    
    /**
     * 
     * @param position
     * @param toRed Indicates whether position must be red
     */
    private void setColor(Position<Entry<K, V>> position, boolean toRed) {
        tree.setAux(position, toRed ? 1 : 0);
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after an insertion.
     * 
     * @param position 
     */
    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> position) {
        if (!isRoot(position)) {
            makeRed(position);
            resolvedRed(position);
        }
    }
    
    /**
     * Remedies potential double-red violation above red position
     * 
     * @param position 
     */
    private void resolvedRed(Position<Entry<K, V>> position) {
        Position<Entry<K, V>> parent, uncle, middle, grand; // used in case analysis
        parent = parent(position);
        
        if (isRed(position)) {                              // double-red problem exists
            uncle = sibling(parent);
            if (isBlack(uncle)) {                           // Case 1: misshapen 4-node
                middle = restructure(position);             // do trinode restructuring
                makeBlack(middle);
                makeRed(left(middle));
                makeRed(right(middle));
            } else {                                        // Case 2: overfull 5-node
                makeBlack(parent);                          // perform recoloring
                makeBlack(uncle);
                grand = parent(parent);
                if (!isRoot(grand)) {
                    makeRed(grand);                         // grandparent becomes red
                    resolvedRed(grand);                     // recur at red grandparent
                }
            }
        }
    }

    /**
     * Overrides the TreeMap rebalancing hook that is called after a deletion.
     * 
     * @param position 
     */
    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> position) {
        if (isRed(position)) {                              // deleted parent was black
            makeBlack(position);                            // so this restores black depth
        } else if (!isRoot(position)) {
            Position<Entry<K, V>> sibling = sibling(position);
            if (isInternal(sibling) && (isBlack(sibling) || isInternal(left(sibling)))) {
                remedyDoubleBlack(position);        // sibling's subtree has nonzero black height
            }
        }
    }

    /**
     * Remedies a presumed double-black violation at the given (nonroot) position.
     * 
     * @param position 
     */
    private void remedyDoubleBlack(Position<Entry<K, V>> position) {
        Position<Entry<K, V>> z = parent(position);
        Position<Entry<K, V>> y = sibling(position);
        
        if (isBlack(y)) {
            if (isRed(left(y)) || isRed(right(y))) {    // Case 1: trinode restructuring
                Position<Entry<K, V>> x = (isRed(left(y)) ? left(y) : right(y));
                Position<Entry<K, V>> middle = restructure(x);
                setColor(middle, isRed(z));             // root of restructured subtree gets z's old color
                makeBlack(left(middle));
                makeBlack(right(middle));
            } else {                                    // Case 2: recoloring
                makeRed(y);
                if (isRed(z)) {
                    makeBlack(z);
                } else if (!isRoot(z)) {
                    remedyDoubleBlack(z);               // propagate the problem
                }
            }
        } else {                                        // Case 3: reorient 3-node
            rotate(y);
            makeBlack(y);
            makeRed(z);
            remedyDoubleBlack(position);                // restart the process at p
        }
        
    }
    
    
}
