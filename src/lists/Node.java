package lists;

public class Node<E> {
    private final E data;
    private Node<E> next;
    private Node<E> previous;

    public Node(E dado) {
        this.data = dado;
        this.next = null;
        this.previous = null;
    }

    public E getData() {
        return this.data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public Node<E> getPrevious() {
        return previous;
    }
}
