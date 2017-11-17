package rogeriogentil.data.structures.chapter10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import rogeriogentil.data.structures.chapter09.Entry;

/**
 *
 * @author Rogerio J. Gentil
 * @param <K> Key
 * @param <V> Value
 */
public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {

    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {
    }

    // -------------- private utility ---------------
    /**
     * Returns the index of an entry with equal key, or −1 if none found.
     *
     * @param key
     * @return
     */
    private int findIndex(K key) {
        int n = table.size();

        for (int i = 0; i < n; i++) {
            if (table.get(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;      // special value denotes that key was not found
    }

    @Override
    public int size() {
        return table.size();
    }

    /**
     * Returns the value associated with the specified key (or else null).
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        int index = this.findIndex(key);

        if (index == -1) {
            return null;        // not found
        }

        return table.get(index).getvalue();
    }

    /**
     * Associates given value with given key, replacing a previous value (if
     * any)
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        int index = this.findIndex(key);

        if (index == -1) {
            table.add(new MapEntry<>(key, value));
            return null;        // not found
        } else {
            V old = table.get(index).getvalue();
            table.get(index).setValue(value);
            return old;
        }
    }

    /**
     * Removes the entry with the specified key (if any) and returns its value.
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        int index = this.findIndex(key);
        int n = table.size();

        if (index == -1) {
            return null;        // not found
        }

        V value = table.get(index).getvalue();

        if (index != n - 1) {
            table.set(index, table.get(n - 1)); // relocate last entry to ’hole’ created by removal
        }

        table.remove(n - 1);    // remove last entry of table
        return value;
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }

    // Support for public entrySet method (above)
    private class EntryIterator implements Iterator<Entry<K, V>> {

        private int j = 0;

        @Override
        public boolean hasNext() {
            return j < table.size();
        }

        @Override
        public Entry<K, V> next() {
            if (j == table.size()) {
                throw new NoSuchElementException();
            }

            return table.get(j++);
        }
    }

    private class EntryIterable implements Iterable<Entry<K, V>> {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }
}
