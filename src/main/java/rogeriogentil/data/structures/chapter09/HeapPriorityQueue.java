package rogeriogentil.data.structures.chapter09;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Rogerio J. Gentil
 * @param <K>
 * @param <V>
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    public HeapPriorityQueue() {
    }

    public HeapPriorityQueue(Comparator<K> c) {
        super(c);
    }
    
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for (int j = 0; j < Math.min(keys.length, values.length); j++) {
            heap.add(new PQEntry<>(keys[j], values[j]));
        }
        heapify();
    }

    // protected utilities
    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return this.left(j) < heap.size();
    }

    protected boolean hasRight(int j) {
        return this.right(j) < heap.size();
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     *
     * @param i
     * @param j
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap
     * property.
     *
     * @param j
     */
    protected void upHeap(int j) {
        while (j > 0) {     // continue until reaching root (or break statement)
            int p = parent(j);

            if (compare(heap.get(j), heap.get(p)) >= 0) {
                break;
            }

            swap(j, p);
            j = p;          // continue from the parent's location
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap
     * property.
     *
     * @param j
     */
    protected void downHeap(int j) {
        while (hasLeft(j)) {             // continue to bottom (or break statement)
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;     // although right may be smaller

            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }

            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0) {
                break;
            }

            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public Entry<K, V> min() {
        if (heap.isEmpty()) {
            return null;
        }

        return heap.get(0);
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upHeap(heap.size() - 1);
        return newest;
    }

    @Override
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        
        Entry<K, V> temp = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downHeap(0);
        return temp;
    }
    
    /**
     * Performs a bottom-up construction of the heap in linear time.
     */
    protected void heapify() {
        int startIndex = parent(size() - 1);        // start at PARENT of last entry
        for (int j = startIndex; j >= 0; j--) {     // loop until processing the root
            downHeap(j);
        }
    }

}
