package rogeriogentil.data.structures.chapter11;

import java.util.Comparator;
import rogeriogentil.data.structures.chapter07.Position;
import rogeriogentil.data.structures.chapter09.Entry;

/**
 * An implementation of a sorted map using an AVL tree.
 * 
 * @author Rogerio J. Gentil
 * @param <K> Key
 * @param <V> Value
 */
public class AVLTreeMap<K, V> extends TreeMap<K, V> {

    public AVLTreeMap() {
    }

    public AVLTreeMap(Comparator<K> comp) {
        super(comp);
    }

    protected int height(Position<Entry<K, V>> position) {
        return tree.getAux(position);
    }
    
    /**
     * Recomputes the height of the given position based on its children's heights.
     * 
     * @param position 
     */
    protected void recomputeHeight(Position<Entry<K, V>> position) {
        tree.setAux(position, 1 + Math.max(height(left(position)), height(right(position))));
    }
    
    /**
     * Returns whether a position has balance factor between −1 and 1 inclusive.
     * 
     * @param position
     * @return 
     */
    protected boolean isBalacend(Position<Entry<K, V>> position) {
        return Math.abs(height(left(position)) - height(right(position))) <= 1;
    }
    
    /**
     * Returns a child of p with height no smaller than that of the other child.
     * 
     * @param position
     * @return 
     */
    protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> position) {
        if (height(left(position)) > height(right(position))) {
            return left(position);
        }
        
        if (height(left(position)) < height(right(position))) {
            return right(position);
        }
        
        // equal height children; break tie while matching parent's orientation
        if (isRoot(position)) {                     // choice is irrelevant
            return left(position);                  // return aligned child
        } else {
            return right(position);
        }
    }
    
    /**
     * Utility used to rebalance after an insert or removal operation. This traverses the path upward from position, 
     * performing a trinode restructuring when imbalance is found, continuing until balance is restored.
     * 
     * @param position 
     */
    protected void rebalance(Position<Entry<K, V>> position) {
        int oldHeight, newHeight;
        do {
            oldHeight = height(position);           // not yet recalculated if internal
            if (!isBalacend(position)) {            // imbalance detected
                
                /* 
                perform trinode restructuring, setting position to resulting root,
                and recompute new local heights after the restructuring. 
                */
                position = restructure(tallerChild(tallerChild(position)));
                recomputeHeight(left(position));
                recomputeHeight(right(position));
            }
            
            recomputeHeight(position);
            newHeight = height(position);
            position = parent(position);
        } while (oldHeight != newHeight && position != null);
    }
    
    /**
     * Overrides the TreeMap rebalancing hook that is called after an insertion.
     * 
     * @param position 
     */
    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> position) {
        rebalance(position);
    }
    
    /**
     * Overrides the TreeMap rebalancing hook that is called after a deletion.
     * 
     * @param position 
     */
    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> position) {
        rebalance(position);
    }
}
