package lists;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<E> {
    protected Object[] v;
    protected int size;

    public ArrayList() {
        this.v = new Object[5];
        this.size = 0;
    }

    public void clear() {
        this.v = new Object[5];
        this.size = 0;
    }

    public void add(E element) {
        this.add(this.size, element);
    }

    @SafeVarargs
    public final void add(E... element) {
        for (E aux : element) {
            this.add(aux);
        }
    }

    public void add(int index, E element) {
        if (this.size == this.v.length) {
            Object[] temp = new Object[this.v.length + 5];
            System.arraycopy(this.v, 0, temp, 0, this.v.length);
            this.v = temp;
        }

        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        System.arraycopy(this.v, index, this.v, index + 1, this.size - index);
        this.v[index] = element;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) this.v[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index < this.size - 1) {
            System.arraycopy(this.v, index + 1, this.v, index, this.size - index);
        }

        this.size--;
    }

    public void remove(E element) {
        this.remove(this.indexOf(element));
    }

    public int indexOf(Object element) {
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(element, v[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E element) {
        for (Object aux : v) {
            if (Objects.equals(element, aux)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Object[] aux = new Object[this.size];
        System.arraycopy(this.v, 0, aux, 0, this.size);
        return Arrays.toString(aux);
    }
}
