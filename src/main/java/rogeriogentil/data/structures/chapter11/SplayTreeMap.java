package rogeriogentil.data.structures.chapter11;

import java.util.Comparator;
import rogeriogentil.data.structures.chapter07.Position;
import rogeriogentil.data.structures.chapter09.Entry;

/**
 * An implementation of a sorted map using a splay tree.
 * 
 * @author Rogerio J. Gentil
 * @param <K> Key
 * @param <V> Value
 */
public class SplayTreeMap<K, V> extends TreeMap<K, V> {

    public SplayTreeMap() {
    }

    public SplayTreeMap(Comparator<K> comp) {
        super(comp);
    }
    
    /**
     * Utility used to rebalance after a map operation.
     * 
     * @param position 
     */
    private void splay(Position<Entry<K, V>> position) {
        while (!isRoot(position)) {
            Position<Entry<K, V>> parent = parent(position);
            Position<Entry<K, V>> grand = parent(parent);
            
            if (grand == null) {                        // zig case
                rotate(position);
            } else if ((parent == left(grand)) == (position == left(parent))) { // zig-zig case
                rotate(parent);         // move PARENT upward
                rotate(position);       // then move position upward
            } else {                                    // zig-zag case
                rotate(position);       // move p upward
                rotate(position);       // move p upward again
            }
        }
    }

    // override the various TreeMap rebalancing hooks to perform the appropriate splay
    @Override
    protected void rebalanceAccess(Position<Entry<K, V>> position) {
        if (isExternal(position)) {
            position = parent(position);
        }
        
        if (position != null) {
            splay(position);
        }
    }

    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> position) {
        splay(position);
    }

    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> position) {
        if (!isRoot(position)) {
            splay(parent(position));
        }
    }
}
