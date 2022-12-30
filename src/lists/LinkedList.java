package lists;

import java.util.Objects;

public class LinkedList<E> {
    protected Node<E> first;
    protected Node<E> last;
    protected int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void add(E element) {
        add(this.size, element);
    }

    public void add(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> aux = new Node<>(element);

        if (index == 0) {
            if (index == this.size) {
                this.first = aux;
                this.last = aux;
            } else {
                aux.setNext(this.first);
                this.first.setPrevious(aux);
                this.first = aux;
            }
        } else {
            if (index == this.size) {
                aux.setPrevious(this.last);
                this.last.setNext(aux);
                this.last = aux;
            } else {
                Node<E> temp = this.first;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.getNext();
                }
                aux.setPrevious(temp);
                aux.setNext(temp.getNext());
                temp.getNext().setPrevious(aux);
                temp.setNext(aux);
            }
        }

        this.size++;
    }

    public E get(int index) {
        Node<E> temp = this.first;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            if (this.size != 1) {
                Node<E> temp = this.first.getNext();
                temp.setPrevious(null);
                this.first = temp;
            } else {
                this.first = null;
                this.last = null;
            }
        } else {
            Node<E> temp;

            if (index == this.size - 1) {
                temp = this.last.getPrevious();
                temp.setNext(null);
                this.last.setPrevious(null);
                this.last = temp;
            } else {
                temp = this.first;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.getNext();
                }
                Node<E> aux = temp.getNext().getNext();
                temp.getNext().setPrevious(null);
                temp.getNext().setNext(null);
                temp.setNext(aux);
            }
        }

        this.size--;
    }

    public void remove(E element) {
        this.remove(this.indexOf(element));
    }

    public int indexOf(E element) {
        Node<E> temp = this.first;
        for (int i = 0; i < this.size; i++) {
            if (Objects.equals(temp.getData(), element)) {
                return i;
            }
            temp = temp.getNext();
        }
        return -1;
    }

    public boolean contains (E element) {
        Node<E> temp = this.first;
        while (temp != null) {
            if (temp.getData().equals(element)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Node<E> temp = this.first;
        String output = "";
        while (temp != null) {
            output = output.concat(temp.getData().toString());
            temp = temp.getNext();
            if (temp != null) {
                output = output.concat(", ");
            }
        }
        return "[".concat(output).concat("]");
    }
}
