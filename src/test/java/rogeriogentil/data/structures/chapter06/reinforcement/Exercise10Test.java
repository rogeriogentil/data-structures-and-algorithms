package rogeriogentil.data.structures.chapter06.reinforcement;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import rogeriogentil.data.structures.chapter06.reinforcement.Exercise10;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise10Test {

   private Exercise10<Integer> ex10;

   @Before
   public void beforeEachTest() {
      ex10 = new Exercise10<>();
   }

   @Test
   public void dequeMustBeEmtpyWhenInitialized() {
      assertThat(ex10.isEmpty(), is(true));
   }

   @Test
   public void lastElementMustBeTheTop() {
      ex10.push(10);
      ex10.push(20);
      ex10.push(30);

      assertThat(ex10.top(), is(equalTo(30)));
   }

   @Test
   public void mustRemoveTheElementOnTheTop() {
      ex10.push(10);
      ex10.push(20);
      ex10.push(30);
      
      ex10.pop();

      assertThat(ex10.top(), is(equalTo(20)));
   }
}
