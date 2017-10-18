package rogeriogentil.data.structures.cap3;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author rogerio
 */
public class CircularyLinkedListTest {

   @Test
   public void deveSerMesmoElementoEmNextQuandoListaEstaVazia() {
      CircularyLinkedList<String> linkedList = new CircularyLinkedList<>();
      linkedList.addFirst("A");

      assertTrue(linkedList.getTailNode().getElement().equals("A"));
      assertTrue(linkedList.getTailNode().getNext().getElement().equals("A"));
      assertTrue(linkedList.getSize() == 1);
   }
   
   @Test
   public void deveAdicionarNoInicio() {
      CircularyLinkedList<String> linkedList = new CircularyLinkedList<>();
      linkedList.addFirst("C");
      linkedList.addFirst("B");
      linkedList.addFirst("A");

      assertTrue(linkedList.getHeadNode().getElement().equals("A"));
      assertTrue(linkedList.getSize() == 3);
   }
   
   @Test
   public void tailDeveApontarParaNovoNoQuandoAdicionarNoInicio() {
      CircularyLinkedList<String> linkedList = new CircularyLinkedList<>();
      linkedList.addFirst("C");
      linkedList.addFirst("B");
      linkedList.addFirst("A");

      assertTrue(linkedList.getTailNode().getNext().getElement().equals("A"));
      assertTrue(linkedList.getSize() == 3);
   }

   @Test
   public void deveAdicionarNoFim() {
      CircularyLinkedList<String> linkedList = new CircularyLinkedList();
      linkedList.addLast("A");
      linkedList.addLast("B");
      linkedList.addLast("C");

      assertTrue(linkedList.getTailNode().getElement().equals("C"));
      assertTrue(linkedList.getSize() == 3);
   }
   
   @Test
   public void tailDeveApontarParaNovoNoQuandoAdicionarNoFim() {
      CircularyLinkedList<String> linkedList = new CircularyLinkedList<>();
      linkedList.addLast("A");
      linkedList.addLast("B");
      linkedList.addLast("C");

      assertTrue(linkedList.getTailNode().getNext().getElement().equals("A"));
      assertTrue(linkedList.getSize() == 3);
   }
   
}
