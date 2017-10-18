package rogeriogentil.data.structures.cap7;

/**
 *
 * @author Rogerio J. Gentil
 */
public interface PositionalList<E> {
    
    Position<E> first();
    
    Position<E> last();
    
    /**
     * Returns the Position immediately before Position p (or null, if p is first).
     * @param p
     * @return
     * @throws IllegalStateException 
     */
    Position<E> before(Position<E> p) throws IllegalStateException;
    
    /**
     * Returns the Position immediately after Position p (or null, if p is last).
     * @param p
     * @return
     * @throws IllegalStateException 
     */
    Position<E> after(Position<E> p) throws IllegalStateException;
    
    /**
     * Inserts element e at the front of the list and returns its new Position.
     * @param element
     * @return 
     */
    Position<E> addFirst(E element);
    
    /**
     * Inserts element e at the back of the list and returns its new Position.
     * @param element
     * @return 
     */
    Position<E> addLast(E element);
    
    /**
     * Inserts element e immediately before Position p and returns its new Position.
     * @param p
     * @param element
     * @return
     * @throws IllegalStateException 
     */
    Position<E> addBefore(Position<E> p, E element) throws IllegalStateException;
    
    /**
     * Inserts element e immediately after Position p and returns its new Position.
     * @param p
     * @param element
     * @return
     * @throws IllegalStateException 
     */
    Position<E> addAfter(Position<E> p, E element) throws IllegalStateException;
    
    /**
     * Replaces the element stored at Position p and returns the replaced element.
     * @param p
     * @param element
     * @return
     * @throws IllegalStateException 
     */
    E set(Position<E> p, E element) throws IllegalStateException;
    
    /**
     * Removes the element stored at Position p and returns it (invalidating p).
     * @param p
     * @return
     * @throws IllegalArgumentException 
     */
    E remove(Position<E> p) throws IllegalArgumentException;
    
    int size();
    
    boolean isEmpty();
}
