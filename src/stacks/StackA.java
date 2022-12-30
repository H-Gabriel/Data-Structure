package stacks;

import lists.ArrayList;

import java.util.EmptyStackException;

public class StackA<E> extends ArrayList<E> {
    public StackA() {
        super();
    }

    public void push(E element) {
        super.add(element);
    }

    public E pop() {
        if (size != 0) {
            E element = peek();
            remove(this.size - 1);
            return element;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        return (E) this.v[this.size - 1];
    }

    @Override
    public String toString() {
        String output = "stack:";
        while (this.size > 0) {
            output = output.concat(System.lineSeparator()).concat(this.pop().toString());
        }
        return output;
    }
}
