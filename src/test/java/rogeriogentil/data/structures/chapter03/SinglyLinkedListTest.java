package rogeriogentil.data.structures.chapter03;

import rogeriogentil.data.structures.chapter03.SinglyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 * @author rogerio
 */
public class SinglyLinkedListTest {

   @Test
   public void deveAdicionarNoInicio() {
      SinglyLinkedList<String> linkedList = new SinglyLinkedList<>();
      linkedList.addFirst("C");
      linkedList.addFirst("B");
      linkedList.addFirst("A");

      assertTrue(linkedList.getHead().getElement().equals("A"));
      assertTrue(linkedList.getSize() == 3);
   }

   @Test
   public void deveAdicionarNoFim() {
      SinglyLinkedList<String> linkedList = new SinglyLinkedList();
      linkedList.addLast("A");
      linkedList.addLast("B");
      linkedList.addLast("C");

      assertTrue(linkedList.getHead().getNext().getNext().getElement().equals("C"));
      assertTrue(linkedList.getSize() == 3);
   }

   @Test
   public void deveIndicarQueListaEstaVazia() {
      SinglyLinkedList linkedList = new SinglyLinkedList();
      assertTrue(linkedList.isEmpty());
   }

   @Test
   public void deveRemoverPrimeiroElemento() {
      SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
      linkedList.addLast(10);
      linkedList.addLast(20);
      linkedList.addLast(30);

      linkedList.removeFist();

      assertTrue(linkedList.getHead().getElement().equals(20));
      assertTrue(linkedList.getSize() == 2);
   }

   @Test
   public void deveExecutarRemoverPrimeiroElementoMesmoQuandoListaEstaVazia() {
      SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
      linkedList.removeFist();
      
      assertTrue(linkedList.getSize() == 0);
   }
   
   @Test
   public void deveRemoverPrimeiroElementoMesmoQuandoListaTemApenasUmNo() {
      SinglyLinkedList<Integer> linkedList = new SinglyLinkedList();
      linkedList.addLast(10);
      linkedList.removeFist();
      
      assertTrue(linkedList.getSize() == 0);
   }
}
