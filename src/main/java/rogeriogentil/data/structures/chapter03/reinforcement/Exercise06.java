package rogeriogentil.data.structures.chapter03.reinforcement;

/**
 * @author rogerio
 */
public class Exercise06 {

    private class SinglyLinkedList<E> {

        private int size;
        private Node<E> headNode;
        private Node<E> tailNode;

        public Node<E> getHead() {
            return headNode;
        }

        public Node<E> getTail() {
            return tailNode;
        }

        public int getSize() {
            return size;
        }

        public void addFirst(E element) {
            Node newest = new Node(element);
            newest.setNext(headNode);
            headNode = newest;

            if (this.isEmpty()) {
                tailNode = headNode;
            }

            size++;
        }

        public void addLast(E element) {
            Node newest = new Node(element);

            if (this.isEmpty()) {
                headNode = newest;
                tailNode = headNode;
            } else {
                tailNode.setNext(newest);
                tailNode = newest;
            }

            size++;
        }

        public void removeFist() {
            if (this.isEmpty()) {
                return;
            }
            headNode = headNode.getNext();
            headNode.setNext(null);
            size--;
        }

        public E removeFirst() { // removes and returns the first element
            if (isEmpty()) {
                return null; // nothing to remove
            }
            E answer = headNode.getElement();
            headNode = headNode.getNext(); // will become null if list had only one node
            size--;

            if (size == 0) {
                tailNode = null; // special case as list is now empty
            }
            return answer;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }
    }

    private class Node<E> {

        private E element;
        private Node<E> next;

        public Node() {
        }

        public Node(E element) {
            this.element = element;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
