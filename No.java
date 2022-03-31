public class No<E> {

    private final E dado;
    private No<E> proximo;

    public No(E dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public E getDado() {
        return this.dado;
    }

    public void setProximo(No<E> proximo) {
        this.proximo = proximo;
    }

    public No<E> getProximo() {
        return this.proximo;
    }
    
}
