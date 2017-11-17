package rogeriogentil.data.structures.chapter07.reinforcement;

import rogeriogentil.data.structures.chapter07.ArrayList;

/**
 * R-7.5 The java.util.ArrayList includes a method, trimToSize(), that replaces 
 * the underlying array with one whose capacity precisely equals the number of 
 * elements currently in the list. Implement such a method for our dynamic 
 * version of the ArrayList class from Section 7.2.
 * 
 * Details: https://docs.oracle.com/javase/9/docs/api/java/util/ArrayList.html#trimToSize--
 * 
 * @author Rogerio J. Gentil
 * @param <E>
 */
public class Exercise05<E> {
     
    /**
     * See the method trimToSize() in the class ArrayList
     */
    public void trimToSize() {
        ArrayList<E> list = new ArrayList<>();
        list.trimToSize();
    }
}
