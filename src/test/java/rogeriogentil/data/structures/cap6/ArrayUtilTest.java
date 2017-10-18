package rogeriogentil.data.structures.cap6;

import java.util.Arrays;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 *
 * @author Rogerio J. Gentil
 */
public class ArrayUtilTest {

    @Test
    public void deveReverterArray() {
        Integer[] array = {10, 20, 30, 40, 50};
        ArrayUtil.reverse(array);

        System.out.println(Arrays.toString(array));
        assertThat(array[0], is(equalTo(50)));
        assertThat(array[1], is(equalTo(40)));
        assertThat(array[2], is(equalTo(30)));
        assertThat(array[3], is(equalTo(20)));
        assertThat(array[4], is(equalTo(10)));
    }
}
