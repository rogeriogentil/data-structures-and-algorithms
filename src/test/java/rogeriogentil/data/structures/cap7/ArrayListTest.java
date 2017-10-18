package rogeriogentil.data.structures.cap7;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
/**
 *
 * @author Rogerio J. Gentil
 */
public class ArrayListTest {

    @Test
    public void deveRemover() {
        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(0, 10);
        list.add(1, 20);
        list.add(2, 30);
        list.add(3, 40);
        list.add(4, 50);
        
        list.remove(3);
        assertThat(list.get(3), is(equalTo(50)));
    }
}
