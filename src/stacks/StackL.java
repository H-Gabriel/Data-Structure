package stacks;

import lists.LinkedList;

import java.util.EmptyStackException;

public class StackL<E> extends LinkedList<E> {
    public StackL() {
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

    public E peek() {
        if (this.size == 0) {
            throw new EmptyStackException();
        }
        return this.last.getData();
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
