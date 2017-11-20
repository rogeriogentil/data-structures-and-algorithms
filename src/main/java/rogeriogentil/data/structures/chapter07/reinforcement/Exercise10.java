package rogeriogentil.data.structures.chapter07.reinforcement;

import rogeriogentil.data.structures.chapter06.Stack;
import rogeriogentil.data.structures.chapter07.ArrayList;

/**
 * R-7.10 Reimplement the ArrayStack class, from Section 6.1.2, using dynamic 
 * arrays to support unlimited capacity.
 * 
 * @author Rogerio J. Gentil
 */
public class Exercise10 {}

class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> data;

    public ArrayStack() {
        this.data = new ArrayList();
    }
    
    @Override
    public void push(E e) {
        this.data.add(this.size(), e);
    }

    @Override
    public E pop() {
        return this.data.remove(size() - 1);
    }

    @Override
    public E top() {
        int i = this.size() - 1;
        return this.data.get(i);
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}