package rogeriogentil.data.structures.cap6;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author rogerio
 */
public class ArrayCircularQueueTest {

   private Queue<String> queue;
   
   @Test
   public void deveInserirUmElemento() {
      String s = "A";
      queue = new ArrayCircularQueue<>(3);
      queue.enqueue(s);
      
      assertThat(queue.first(), is(equalTo(s)));
   }
   
   @Test
   public void deveRemoverUmElementoDoComeco() {
      String s = "A";
      queue = new ArrayCircularQueue<>(3);
      queue.enqueue(s);
      queue.enqueue("B");
      queue.enqueue("C");
      
      assertThat(queue.dequeue(), is(equalTo(s)));
   }
   
   @Test
   public void deveInserirUmElementoNoInicioQuandoFilaVoltar() {
      String s = "A";
      queue = new ArrayCircularQueue<>(3);
      queue.enqueue("B");
      queue.enqueue("C");
      queue.enqueue("D");
      queue.dequeue(); // remove "B"
      queue.enqueue(s);
      
      assertThat(queue.size(), is(equalTo(3)));
   }
   
   @Test
   public void deveInserirCriarUmaFilaVazia() {
      queue = new ArrayCircularQueue<>(3);
      
      assertThat(queue.isEmpty(), is(true));
   }
   
   @Test(expected = IllegalStateException.class)
   public void deveLancarExcecaoTentarInserirElementoQuandoFilaEstaCheia() {
      queue = new ArrayCircularQueue<>(3);
      queue.enqueue("A");
      queue.enqueue("B");
      queue.enqueue("C");
      queue.enqueue("D");
   }
   
   @Test
   public void deveRetornarTamanho() {
      queue = new ArrayCircularQueue<>(4);
      queue.enqueue("A");
      queue.enqueue("B");
      queue.enqueue("C");
      queue.enqueue("D");
    
      assertThat(queue.size(), is(equalTo(4)));
   }
}
