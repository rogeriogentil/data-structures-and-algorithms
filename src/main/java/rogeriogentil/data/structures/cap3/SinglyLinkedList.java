package rogeriogentil.data.structures.cap3;

/**
 *
 * @author rogerio
 */
public class SinglyLinkedList<E> {

   private int size;
   private Node<E> headNode;
   private Node<E> tailNode;

   public Node<E> getHead() {
      return headNode;
   }

   public Node<E> getTail() {
      return tailNode;
   }

   public int getSize() {
      return size;
   }

   public void addFirst(E element) {
      Node newest = new Node(element);
      newest.setNext(headNode);
      headNode = newest;
      
      if (this.isEmpty()) {
         tailNode = headNode;
      }
      
      size++;
   }

   public void addLast(E element) {
      Node newest = new Node(element);
      
      if (this.isEmpty()) {
         headNode = newest;
         tailNode = headNode;
      } else {
         tailNode.setNext(newest);
         tailNode = newest;
      }
      
      size++;
   }

   public E removeFist() {
      if (this.isEmpty()) {
          return null;
      }
      
      E element = headNode.getElement();
      headNode = headNode.getNext();
//      headNode.setNext(null);
      size--;
      
      return element;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }
   
   public E first() {
       return headNode.getElement();
   }
}

