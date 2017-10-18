package rogeriogentil.data.structures.cap6.reinforcement;

import java.util.Arrays;
import org.junit.Test;
import rogeriogentil.data.structures.cap6.ArrayStack;
import rogeriogentil.data.structures.cap6.Stack;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise4Test {

   @Test
   public void deveTransferirPilhaInvertendoTopo() {
      Stack<String> s = new ArrayStack<>(5);
      s.push("A");
      s.push("B");
      s.push("C");
      s.push("D");

      Stack<String> t = new ArrayStack<>(5);
      assertThat(t.top(), is(equalTo(null)));
      
      Exercise4.transfer(s, t);
      
      assertThat(t.top(), is(equalTo("A")));
   }
}
