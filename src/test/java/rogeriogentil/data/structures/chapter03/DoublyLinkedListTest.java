package rogeriogentil.data.structures.chapter03;

import rogeriogentil.data.structures.chapter03.DoublyLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author rogerio
 */
public class DoublyLinkedListTest {

   @Test
   public void deveInicialiarListaDuplamenteEncadeada() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();

      assertTrue(linkedList.getHeader().getNext().equals(linkedList.getTrailer()));
      assertTrue(linkedList.getTrailer().getPrevious().equals(linkedList.getHeader()));
   }

   @Test
   public void deveInicialiarListaDuplamenteEncadeadaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();

      assertTrue(linkedList.isEmpty());
   }

   @Test
   public void deveAdicionarNoInicioQuandoListaEstaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.addFirst("A");

      assertEquals("A", linkedList.getHeader().getNext().getElement());
   }

   @Test
   public void deveAdicionarNoInicioQuandoListaJaTemNos() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.addFirst("C");
      linkedList.addFirst("B");
      linkedList.addFirst("A");

      assertEquals("A", linkedList.getHeader().getNext().getElement());
      assertEquals("B", linkedList.getHeader().getNext().getNext().getElement());
      assertEquals("C", linkedList.getTrailer().getPrevious().getElement());
      assertThat(linkedList.getSize(), is(equalTo(3)));
   }

   @Test
   public void deveRetornarPrimeiroElementoNuloQuandoListaEstaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();

      assertNull(linkedList.first());
   }

   @Test
   public void deveRetornarPrimeiroElemento() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.addFirst("A");

      assertEquals("A", linkedList.first());
   }

   @Test
   public void deveAdicionarNoFimQuandoListaEstaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.addLast("A");

      assertEquals("A", linkedList.getTrailer().getPrevious().getElement());
   }

   @Test
   public void deveAdicionarNoFimQuandoListaJaTemNos() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.addLast("A");
      linkedList.addLast("B");
      linkedList.addLast("C");

      assertEquals("C", linkedList.getTrailer().getPrevious().getElement());
      assertEquals("B", linkedList.getTrailer().getPrevious().getPrevious().getElement());
      assertEquals("A", linkedList.getHeader().getNext().getElement());
      assertThat(linkedList.getSize(), is(equalTo(3)));
   }

   @Test
   public void deveRetornarUltimoElementoNuloQuandoListaEstaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();

      assertNull(linkedList.last());
   }

   @Test
   public void deveRetornarUltimoElemento() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.addLast("A");

      assertEquals("A", linkedList.first());
   }

   @Test
   public void deveExecutarRemocaoNoInicioMesmoQuandoListaEstaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.removeFirst();

      assertThat(linkedList.getSize(), is(equalTo(0)));
   }

   @Test
   public void deveRemoverNoInicioQuandoListaNaoEstaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.addFirst("C");
      linkedList.addFirst("B");
      linkedList.addFirst("A");

      linkedList.removeFirst();

      assertEquals("B", linkedList.getHeader().getNext().getElement());
      assertEquals("C", linkedList.getTrailer().getPrevious().getElement());
      assertThat(linkedList.getSize(), is(equalTo(2)));
   }

   @Test
   public void deveExecutarRemocaoNoFimMesmoQuandoListaEstaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.removeLast();

      assertThat(linkedList.getSize(), is(equalTo(0)));
   }

   @Test
   public void deveRemoverNoFimQuandoListaNaoEstaVazia() {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
      linkedList.addLast("A");
      linkedList.addLast("B");
      linkedList.addLast("C");

      linkedList.removeLast();

      assertEquals("A", linkedList.getHeader().getNext().getElement());
      assertEquals("B", linkedList.getTrailer().getPrevious().getElement());
      assertThat(linkedList.getSize(), is(equalTo(2)));
   }
}
