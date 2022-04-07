import java.util.Objects;

public class myArrayList<E> {
    protected Object[] v;
    protected int size;

    public myArrayList() {
        this.v = new Object[5];
        this.size = 0;
    }
    
    public myArrayList(Object[] v) {
        this.v = v;
        this.size = v.length;
    }


    public void add(E element) {
        add(this.size, element);
    }

    public void add(int index, E element) {
            if(this.size == this.v.length) { //(size+1 ≤ v.length) significa que existe pelo menos uma última posição vazia
                Object[] aux = new Object[this.v.length + 5];
                System.arraycopy(this.v, 0, aux, 0, this.v.length);
                this.v = aux;
            }

            if(index <= this.size) {
                for (int i = this.size; i > index; i--){
                    this.v[i] = this.v[i-1];
                }
            }

            if(index > this.size) {
                System.out.println("Posição inválida");
                return;
            }

            this.v[index] = element;
            this.size++;
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.v = new Object[5];
        this.size = 0;
    }

    public boolean contains(E element) {
        for(int i = 0; i < this.size; i++) {
            if(Objects.equals(this.v[i], element)) return true;
        }
        return false;
    }

    public void remove(int index) {
        if(index < this.size){
            this.size--;
            if(index < this.size - 1) {
                for(int i = index; i < this.size; i++) {
                    this.v[i] = this.v[i+1];
                }
            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) this.v[index];
    }

    public int indexOf(E element) {
        for(int i = 0; i < this.size; i++) {
            if(Objects.equals(this.v[i], element)) return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "meu nome é cleitin";
    }

}
