package rogeriogentil.data.structures.cap3;

/**
 *
 * @author rogerio
 */
public class Node<E> {

   private E element;
   private Node<E> next;

   public Node() {
   }

   public Node(E element) {
      this.element = element;
   }

   public E getElement() {
      return element;
   }

   public void setElement(E element) {
      this.element = element;
   }

   public Node<E> getNext() {
      return next;
   }

   public void setNext(Node<E> next) {
      this.next = next;
   }
}

