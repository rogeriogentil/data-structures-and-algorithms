package rogeriogentil.data.structures.chapter10;

import java.util.Iterator;
import rogeriogentil.data.structures.chapter09.Entry;

/**
 *
 * @author Rogerio J. Gentil
 * @param <K> Key
 * @param <V> Value
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    //---------------- nested MapEntry class ----------------
    protected static class MapEntry<K, V> implements Entry<K, V> {

        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public V getvalue() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
    //----------- end of nested MapEntry class -----------

    // ---------- Key 
    private class KeyIterator implements Iterator<K> {

        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public K next() {
            return entries.next().getKey();     // return key!
        }
    }

    private class KeyIterable implements Iterable<K> {

        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    // ---------- Value
    private class ValueIterator implements Iterator<V> {

        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        @Override
        public boolean hasNext() {
            return entries.hasNext();
        }

        @Override
        public V next() {
            return entries.next().getvalue();   // return value!
        }
    }

    private class ValueIterable implements Iterable<V> {

        @Override
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
