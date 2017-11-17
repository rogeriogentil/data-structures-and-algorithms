package rogeriogentil.data.structures.chapter06;

import rogeriogentil.data.structures.chapter06.ArrayStack;
import rogeriogentil.data.structures.chapter06.Stack;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author rogerio
 */
public class ArrayStackTest {

   @Test
   public void deveIndicarQuePilhaEstaVaziaAoInicializarObjeto() {
      Stack<Integer> stack = new ArrayStack<>();
      assertThat(stack.isEmpty(), is(true));
   }

   @Test
   public void deveAdicionarUmElementoNaPilha() {
      Stack<Integer> stack = new ArrayStack<>(1);
      stack.push(10);

      assertThat(stack.size(), is(equalTo(1)));
   }
   
   @Test
   public void deveObterElementoDoTopoDaPilha() {
      Stack<Integer> stack = new ArrayStack<>(3);
      stack.push(10);
      stack.push(25);
      stack.push(50);

      assertThat(stack.top(), is(equalTo(50)));
   }

   @Test(expected = IllegalStateException.class)
   public void deveLancarExcecaoAoExcederLimiteDeCapacidadeDaPilhar() {
      Stack<Integer> stack = new ArrayStack<>(3);
      stack.push(10);
      stack.push(20);
      stack.push(30);
      stack.push(40);
   }
   
}
