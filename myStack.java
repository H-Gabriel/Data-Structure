import java.util.EmptyStackException;

public class myStack<E> extends myArrayList<E> {

    public myStack() {
        this.size = 0;
    }

    public void push(E element) {
        add(element);
    }

    public E pop() {
        if(size != 0) {
            E element = peek();
            remove(size - 1);
            return element;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if(this.size == 0) {
            throw new EmptyStackException();
        }
        return (E) this.v[size - 1];
    }

}
