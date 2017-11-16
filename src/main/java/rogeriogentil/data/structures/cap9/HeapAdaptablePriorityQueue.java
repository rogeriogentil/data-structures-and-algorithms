package rogeriogentil.data.structures.cap9;

import java.util.Comparator;

/**
 * An implementation of an adaptable priority queue using an array-based heap.
 *
 * @author Rogerio J. Gentil
 */
public class HeapAdaptablePriorityQueue<K, V> extends HeapPriorityQueue<K, V> implements AdaptablePriorityQueue<K, V> {

    //---------------- nested AdaptablePQEntry class ----------------
    protected static class AdaptablePQEntry<K, V> extends PQEntry<K, V> {

        private int index;

        public AdaptablePQEntry(K key, V value, int index) {
            super(key, value);
            index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public HeapAdaptablePriorityQueue() {
        super();
    }

    public HeapAdaptablePriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    /**
     * Validates an entry to ensure it is location-aware.
     *
     * @param entry
     * @return
     * @throws IllegalArgumentException
     */
    protected AdaptablePQEntry<K, V> validate(Entry<K, V> entry) throws IllegalArgumentException {
        if (!(entry instanceof AdaptablePQEntry)) {
            throw new IllegalArgumentException("Invalid entry");
        }

        AdaptablePQEntry<K, V> locator = (AdaptablePQEntry<K, V>) entry;

        int index = locator.getIndex();
        if (index >= heap.size() || heap.get(index) != locator) {
            throw new IllegalArgumentException("Invalid entry");
        }

        return locator;
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     *
     * @param i
     * @param j
     */
    @Override
    protected void swap(int i, int j) {
        super.swap(i, j);

        // reset entry's index
        AdaptablePQEntry<K, V> iEntry = (AdaptablePQEntry<K, V>) heap.get(i);
        AdaptablePQEntry<K, V> jEntry = (AdaptablePQEntry<K, V>) heap.get(j);
        iEntry.setIndex(j);
        jEntry.setIndex(i);
    }

    /**
     * Restores the heap property by moving the entry at index j
     * upward/downward.
     *
     * @param index
     */
    protected void bubble(int index) {
        if (index > 0 && compare(heap.get(index), heap.get(parent(index))) < 0) {
            upHeap(index);
        } else {
            downHeap(index);
        }
    }

    /**
     * Inserts a key-value pair and returns the entry created.
     *
     * @param key
     * @param value
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new AdaptablePQEntry<>(key, value, heap.size());
        heap.add(newest);
        upHeap(heap.size() - 1);    // upheap newly added entry
        return newest;
    }
    
    /**
     * Removes the given entry from the priority queue.
     * 
     * @param entry
     * @throws IllegalArgumentException 
     */
    @Override
    public void remove(Entry<K, V> entry) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        int index = locator.getIndex();
        
        if (index == heap.size() - 1) {     // entry is at last position
            heap.remove(heap.size() - 1);
        } else {
            swap(index, heap.size() - 1);   // swap entry to last position
            heap.remove(heap.size() - 1);   // then remove it
            bubble(index);                  // and fix entry displaced by the swap
        }
    }
    
    /**
     * Replaces the key of an entry. 
     * 
     * @param entry
     * @param key
     * @throws IllegalArgumentException 
     */
    @Override
    public void replaceKey(Entry<K, V> entry, K key) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        checkKey(key);
        locator.setKey(key);
        bubble(locator.getIndex());         // with new key, may need to move entry
    }
    
    /**
     * Replaces the value of an entry.
     * Replaces the value of an entry.
     * @param entry
     * @param value
     * @throws IllegalArgumentException 
     */
    @Override
    public void replaceValue(Entry<K, V> entry, V value) throws IllegalArgumentException {
        AdaptablePQEntry<K, V> locator = validate(entry);
        locator.setValue(value);
    }
}
