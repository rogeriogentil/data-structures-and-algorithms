package rogeriogentil.data.structures.cap3;

/**
 *
 * @author rogerio
 * @param <E>
 */
public class CircularyLinkedList<E> {
   
   private int size;
   private Node<E> tailNode;

   public int getSize() {
      return size;
   }
   
   public Node<E> getHeadNode() {
      return tailNode.getNext();
   }

   public Node<E> getTailNode() {
      return tailNode;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   public E first() {
      if (this.isEmpty()) 
         return null;
      
      return getTailNode().getNext().getElement();
   }
   
   public E last() {
      if (this.isEmpty()) 
         return null;
      
      return getTailNode().getNext().getElement();
   }
   
   public void addFirst(E element) {
      Node<E> newest = new Node<>(element);
      
      if (isEmpty()) {
         tailNode = newest;         
      } else {
         newest.setNext(tailNode.getNext());
      }
      
      tailNode.setNext(newest);
      
      size++;
   }

   public void addLast(E element) {
      Node<E> newest = new Node<>(element);
      
      if (this.isEmpty()) {
         tailNode = newest;
         tailNode.setNext(newest);
         newest.setNext(tailNode);
      } else {
         newest.setNext(tailNode.getNext());
         tailNode.setNext(newest);
         tailNode = newest;
      }
      
      size++;
   }
   
   public void rotate() {
      if (!isEmpty()) {
         tailNode = tailNode.getNext();
      }
   }
}