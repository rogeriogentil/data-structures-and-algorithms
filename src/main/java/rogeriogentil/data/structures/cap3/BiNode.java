package rogeriogentil.data.structures.cap3;

/**
 *
 * @author rogerio
 * @param <E>
 */
public class BiNode<E> {

   private BiNode<E> previous;
   private E element;
   private BiNode<E> next;

   public BiNode() {
   }

   public BiNode(E element) {
      this.element = element;
   }

   public BiNode<E> getPrevious() {
      return previous;
   }

   public void setPrevious(BiNode<E> previous) {
      this.previous = previous;
   }

   public E getElement() {
      return element;
   }

   public void setElement(E element) {
      this.element = element;
   }

   public BiNode<E> getNext() {
      return next;
   }

   public void setNext(BiNode<E> next) {
      this.next = next;
   }

}
