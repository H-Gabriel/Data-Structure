import java.util.Objects;

public class myLinkedList<E extends Comparable<E>> {

    private No<E> primeiro;
    private No<E> ultimo;
    private int size;

    public myLinkedList() {
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(E element) {
        No<E> novo = new No<E>(element);

        if(this.ultimo == null) {
            add(this.size, element);
        }
        else{
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
            this.size++;
        }
    }

    public void add(int index, E element) {
        No<E> novo = new No<E>(element);

        if(index == 0) {
            if(index == this.size){ //Lista estava vazia
                this.primeiro = novo;
                this.ultimo = novo;
            }
            else{
                novo.setProximo(this.primeiro);
                this.primeiro = novo;
            }
        }

        if(index > 0 && index < this.size) {
            No<E> aux = this.primeiro;
            for(int i = 0; i < index - 1; i++) {
                aux = aux.getProximo();
            }
            novo.setProximo(aux.getProximo());
            aux.setProximo(novo);
        }

        this.size++;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public boolean contains(E element) {
        No<E> aux = this.primeiro;
        for (int i = 0; i < this.size; i++) {
            if(Objects.equals(aux.getDado(), element)) return true;
            aux = aux.getProximo();
        }
        return false;
    }

    public void remove(int index){
        No<E> aux = this.primeiro;

        for (int i = 0; i < index - 1; i++) {
            aux = aux.getProximo();
        }

        if(index < this.size) {
            if(index == 0) {
                this.primeiro = aux.getProximo();
            }
            else{
                aux.setProximo(aux.getProximo().getProximo());

                if(index == this.size - 1) {
                    this.ultimo = aux;
                }
            }
            this.size--;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public E get(int index){
        No<E> aux = primeiro;
        for (int i = 0; i < index; i++) {
            aux = aux.getProximo();
        }
        return aux.getDado();
    }

    public int indexOf(E element){
        No<E> aux = primeiro;
        for (int i = 0; i < this.size; i++) {
            if(Objects.equals(aux.getDado(), element)) return i;
            aux = aux.getProximo();
        }
        return -1;
    }

}