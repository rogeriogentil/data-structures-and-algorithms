package rogeriogentil.data.structures.chapter03;

/**
 *
 * @author rogerio
 * @param <E>
 */
public class DoublyLinkedList<E> {

   private int size;
   private BiNode<E> header;
   private BiNode<E> trailer;

   public DoublyLinkedList() {
      header = new BiNode<>();
      trailer = new BiNode<>();

      header.setNext(trailer);
      trailer.setPrevious(header);
   }

   public int getSize() {
      return size;
   }

   public BiNode<E> getHeader() {
      return header;
   }

   public BiNode<E> getTrailer() {
      return trailer;
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public void addFirst(E element) {
      BiNode<E> node = new BiNode<>(element);
      node.setPrevious(header);
      node.setNext(header.getNext());

      header.getNext().setPrevious(node);
      header.setNext(node);

      size++;
   }

   public E first() {
      return this.header.getNext().getElement();
   }

   public void addLast(E element) {
      BiNode<E> node = new BiNode<>(element);
      node.setPrevious(trailer.getPrevious());
      node.setNext(trailer);

      trailer.getPrevious().setNext(node);
      trailer.setPrevious(node);
      size++;
   }

   public E last() {
      return trailer.getPrevious().getElement();
   }

   public void removeFirst() {
      if (isEmpty()) return;
      
      header.setNext(header.getNext().getNext());
      header.getNext().getNext().setPrevious(header);
      size--;
   }
   
   public void removeLast() {
      if (isEmpty()) return;
      
      trailer.setPrevious(trailer.getPrevious().getPrevious());
      trailer.getPrevious().getPrevious().setNext(trailer);
      size--;
   }
}
