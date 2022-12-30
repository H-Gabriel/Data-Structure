package lists;

public class SortedList<E extends Comparable<E>> extends LinkedList<E> {

    public SortedList() {
        super();
    }

    /*
    Esse método poderia ser otimizado paa rodar mais rápido, mas creio
    que a diferença seria tão desprezível que fiquei com preguiça de otimizar
     */
    @Override
    public void add(int index, E element) {
        if (this.size == 0) {
            Node<E> aux = new Node<>(element);
            this.first = aux;
            this.last = aux;
            this.size++;
        } else {
            Node<E> temp = this.first;
            for (int i = 0; i < this.size; i++) {
                if (element.compareTo(temp.getData()) < 0) {
                    super.add(i, element);
                    return;
                }
                temp = temp.getNext();
            }
            super.add(this.size, element);
        }
    }
}