/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package rogeriogentil.data.structures.chapter10;

import rogeriogentil.data.structures.chapter09.Entry;

/**
 * A map with additional support for keys from a total ordering.
 *
 * The total ordering is the natural ordering of keys, by default,
 * or it can be defined by providing an optional Comparator.
 *
 * All iterations will be in sorted order relative to the keys,
 * and additional methods provide for non-exact searches.
 * This interface is a simple variant that blends features of
 * java.util.SortedMap and java.util.NavigableMap.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface SortedMap<K,V> extends Map<K,V>{

  /**
   * Returns the entry having the least key (or null if map is empty).
   * @return entry with least key (or null if map is empty)
   */
  Entry<K,V> firstEntry();

  /**
   * Returns the entry having the greatest key (or null if map is empty).
   * @return entry with greatest key (or null if map is empty)
   */
  Entry<K,V> lastEntry();

  /**
   * Returns the entry with least key greater than or equal to given key
   * (or null if no such key exists).
   * @return entry with least key greater than or equal to given (or null if no such entry)
   * @throws IllegalArgumentException if the key is not compatible with the map
   */
  Entry<K,V> ceilingEntry(K key) throws IllegalArgumentException;

  /**
   * Returns the entry with greatest key less than or equal to given key
   * (or null if no such key exists).
   * @return entry with greatest key less than or equal to given (or null if no such entry)
   * @throws IllegalArgumentException if the key is not compatible with the map
   */
  Entry<K,V> floorEntry(K key) throws IllegalArgumentException;

  /**
   * Returns the entry with greatest key strictly less than given key
   * (or null if no such key exists).
   * @return entry with greatest key strictly less than given (or null if no such entry)
   * @throws IllegalArgumentException if the key is not compatible with the map
   */
  Entry<K,V> lowerEntry(K key) throws IllegalArgumentException;

  /**
   * Returns the entry with least key strictly greater than given key
   * (or null if no such key exists).
   * @return entry with least key strictly greater than given (or null if no such entry)
   * @throws IllegalArgumentException if the key is not compatible with the map
   */
  Entry<K,V> higherEntry(K key) throws IllegalArgumentException;

  /**
   * Returns an iterable containing all keys in the range from
   * <code>fromKey</code> inclusive to <code>toKey</code> exclusive.
   * @return iterable with keys in desired range
   * @throws IllegalArgumentException if <code>fromKey</code> or <code>toKey</code> is not compatible with the map
   */
  Iterable<Entry<K,V>> subMap(K fromKey, K toKey) throws IllegalArgumentException;
}
