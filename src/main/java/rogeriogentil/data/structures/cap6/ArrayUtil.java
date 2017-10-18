package rogeriogentil.data.structures.cap6;

/**
 *
 * @author Rogerio J. Gentil
 */
public class ArrayUtil {

    private ArrayUtil() {}
    
    public static <E> void reverse(E[] array) {
        Stack<E> stack = new ArrayStack<>(array.length);

        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
    }
}
