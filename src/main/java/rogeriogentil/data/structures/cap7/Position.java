package rogeriogentil.data.structures.cap7;

/**
 *
 * @author Rogerio J. Gentil
 */
public interface Position<E> {
    
    /**
     * Returns the element stored at this position.
     * 
     * @return An element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;
}
