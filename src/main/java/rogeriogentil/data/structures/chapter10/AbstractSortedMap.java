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

import java.util.Comparator;
import rogeriogentil.data.structures.chapter09.DefaultComparator;
import rogeriogentil.data.structures.chapter09.Entry;

/**
 * An abstract base class to ease the implementation of the SortedMap interface.
 *
 * The base class provides four means of support:
 * 1) It defines a PQEntry class as a concrete implementation of the
 *    entry interface
 * 2) It provides an instance variable for a general Comparator and
 *    protected methods, compare(a, b), that can compare either two
 *    entries or two keys using the comparator.
 * 3) It provides a boolean checkKey method that verifies that a given key
 *    is appropriate for use with the comparator
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public abstract class AbstractSortedMap<K,V> extends AbstractMap<K, V> implements SortedMap<K,V> {

  // instance variable for an AbstractSortedMap
  /** The comparator defining the ordering of keys in the map. */
  private Comparator<K> comp;

  /**
   * Initializes the comparator for the map.
   * @param c comparator defining the order of keys in the map
   */
  protected AbstractSortedMap(Comparator<K> c) {
    comp = c;
  }

  /** Initializes the map with a default comparator. */
  protected AbstractSortedMap() {
    this(new DefaultComparator<K>());    // default comparator uses natural ordering
  }

  /** Method for comparing two entries according to key */
  protected int compare(Entry<K,V> a, Entry<K,V> b) {
    return comp.compare(a.getKey(), b.getKey());
  }

  /** Method for comparing a key and an entry's key */
  protected int compare(K a, Entry<K,V> b) {
    return comp.compare(a, b.getKey());
  }

  /** Method for comparing a key and an entry's key */
  protected int compare(Entry<K,V> a, K b) {
    return comp.compare(a.getKey(), b);
  }

  /** Method for comparing two keys */
  protected int compare(K a, K b) {
    return comp.compare(a, b);
  }

  /** Determines whether a key is valid. */
  protected boolean checkKey(K key) throws IllegalArgumentException {
    try {
      return (comp.compare(key,key)==0);   // see if key can be compared to itself
    } catch (ClassCastException e) {
      throw new IllegalArgumentException("Incompatible key");
    }
  }
}
