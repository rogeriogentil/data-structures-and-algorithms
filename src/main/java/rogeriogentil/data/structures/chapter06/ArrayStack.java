package rogeriogentil.data.structures.chapter06;

/**
 *
 * @author rogerio
 */
public class ArrayStack<E> implements Stack<E> {

    private static final int CAPACITY = 1000;
    private int top = -1;
    private E[] array;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(final int capacity) {
        this.array = (E[]) new Object[capacity];    // safe cast; compiler may give warning
    }

    @Override
    public void push(E e) {
        if (array.length == size()) {
            throw new IllegalStateException("Stack is full");
        }

        top++;
        array[top] = e;
    }

    @Override
    public E pop() {
        if (this.isEmpty()) {
            return null;
        }

        E e = array[top];
        array[top] = null;
        top--;
        return e;
    }

    @Override
    public E top() {
        if (this.isEmpty()) {
            return null;
        }

        return array[top];
    }

    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

}
