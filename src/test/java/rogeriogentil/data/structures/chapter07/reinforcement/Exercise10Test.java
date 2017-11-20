package rogeriogentil.data.structures.chapter07.reinforcement;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Rogerio J. Gentil
 */
public class Exercise10Test {

    private ArrayStack<Integer> stack;
    
    @Before
    public void beforeEachTest() {
        stack = new ArrayStack<>();
    }
            
    @Test
    public void mustInitializeEmptyStack() {
        assertThat(stack.isEmpty(), is(true));
    }
    
    @Test
    public void lastInsertedElementMustBeOnTheTop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        assertThat(stack.top(), is(equalTo(30)));
    }
    
    @Test
    public void mustRemoveOfTheTop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        stack.pop();
        
        assertThat(stack.top(), is(equalTo(20)));
    }
}
