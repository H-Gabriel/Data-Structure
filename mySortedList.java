import java.util.Objects;

public class mySortedList<E extends Comparable<E>> {
    private No<E> primeiro;
    private No<E> ultimo;
    private int size;

    public mySortedList() {
        this.primeiro = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(E element) {
        if(this.primeiro == null) {
            add(this.size, element);
        }
        else{
            No<E> aux = primeiro;
            for (int i = 0; i < this.size; i++) {
                if(element.compareTo(aux.getDado()) < 0) {
                    add(i, element);
                    break;
                }
                aux = aux.getProximo();
            }
            if(aux == null) {
                add(this.size, element);
            }
        }
    }

    private void add(int index, E element) {
        No<E> novo = new No<>(element);

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

        if(index == this.size()) {
            this.ultimo.setProximo(novo);
            novo.setProximo(null);
            ultimo = novo;
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

    public boolean contains(String element) {
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

    public int indexOf(String element){
        No<E> aux = primeiro;
        for (int i = 0; i < this.size; i++) {
            if(Objects.equals(aux.getDado(), element)) return i;
            aux = aux.getProximo();
        }
        return -1;
    }

}
