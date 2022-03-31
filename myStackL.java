import java.util.EmptyStackException;

public class myStackL<E> extends myLinkedList<E> {

    public myStackL() {
        this.size = 0;
    }

    public void push(E element) {
        add(element);
    }

    public E pop() {
        if(size != 0) {
            E element = peek();
            remove(this.size - 1);
            return element;
        }
        return null;
    }


    public E peek() {
        if(this.size == 0) {
            throw new EmptyStackException();
        }
        return this.ultimo.getDado();
    }

}