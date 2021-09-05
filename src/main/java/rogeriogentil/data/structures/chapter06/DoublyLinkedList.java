package rogeriogentil.data.structures.chapter06;

import rogeriogentil.data.structures.chapter03.*;

/**
 * Copied class of the chapter 3.
 * 
 * @author rogerio
 * @param <E>
 */
public class DoublyLinkedList<E> implements Deque<E> {

   private int size;
   private BiNode<E> header;
   private BiNode<E> trailer;

   public DoublyLinkedList() {
      header = new BiNode<>();
      trailer = new BiNode<>();

      header.setNext(trailer);
      trailer.setPrevious(header);
   }

   public BiNode<E> getHeader() {
      return header;
   }

   public BiNode<E> getTrailer() {
      return trailer;
   }

   @Override
   public boolean isEmpty() {
      return this.size == 0;
   }

   @Override
   public void addFirst(E element) {
      BiNode<E> node = new BiNode<>(element);
      node.setPrevious(header);
      node.setNext(header.getNext());

      header.getNext().setPrevious(node);
      header.setNext(node);

      size++;
   }

   @Override
   public E first() {
      return this.header.getNext().getElement();
   }

   @Override
   public void addLast(E element) {
      BiNode<E> node = new BiNode<>(element);
      node.setPrevious(trailer.getPrevious());
      node.setNext(trailer);

      trailer.getPrevious().setNext(node);
      trailer.setPrevious(node);
      size++;
   }

   @Override
   public E last() {
      return trailer.getPrevious().getElement();
   }

   @Override
   public E removeFirst() {
      if (isEmpty()) {
         return null;
      }

      E element = header.getNext().getElement();
      header.setNext(header.getNext().getNext());
      header.getNext().getNext().setPrevious(header);
      size--;
      return element;
   }

   @Override
   public E removeLast() {
      if (isEmpty()) {
         return null;
      }

      E element = trailer.getPrevious().getElement();
      trailer.getPrevious().getPrevious().setNext(trailer);
      trailer.setPrevious(trailer.getPrevious().getPrevious());
      size--;
      return element;
   }

   @Override
   public int size() {
      return size;
   }
}
