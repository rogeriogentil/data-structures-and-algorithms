package rogeriogentil.data.structures.cap9;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rogerio J. Gentil
 */
public class StringLengthComparatorTest {

   @Test
   public void mustBeEquals() {
      final String s1 = "abc";
      final String s2 = "xyz";

      StringLengthComparator slc = new StringLengthComparator();
      int result = slc.compare(s1, s2);

      assertThat(result, is(equalTo(0)));
   }
   
   @Test
   public void mustReturnOneNegative() {
      final String s1 = "abc";
      final String s2 = "wxyz";

      StringLengthComparator slc = new StringLengthComparator();
      int result = slc.compare(s1, s2);

      assertThat(result, is(equalTo(-1)));
   }
   
   @Test
   public void mustReturnOne() {
      final String s1 = "abcde";
      final String s2 = "xyz";

      StringLengthComparator slc = new StringLengthComparator();
      int result = slc.compare(s1, s2);

      assertThat(result, is(equalTo(1)));
   }

}
