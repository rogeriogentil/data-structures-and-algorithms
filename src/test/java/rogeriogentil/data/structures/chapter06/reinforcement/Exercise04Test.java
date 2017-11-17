package rogeriogentil.data.structures.chapter06.reinforcement;

import rogeriogentil.data.structures.chapter06.reinforcement.Exercise04;
import java.util.Arrays;
import org.junit.Test;
import rogeriogentil.data.structures.chapter06.ArrayStack;
import rogeriogentil.data.structures.chapter06.Stack;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise04Test {

   @Test
   public void deveTransferirPilhaInvertendoTopo() {
      Stack<String> s = new ArrayStack<>(5);
      s.push("A");
      s.push("B");
      s.push("C");
      s.push("D");

      Stack<String> t = new ArrayStack<>(5);
      assertThat(t.top(), is(equalTo(null)));
      
      Exercise04.transfer(s, t);
      
      assertThat(t.top(), is(equalTo("A")));
   }
}
