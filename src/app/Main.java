package app;

import lists.ArrayList;
import lists.LinkedList;
import lists.SortedList;
import stacks.StackA;
import stacks.StackL;

public class Main {
    public static void main(String[] args) {
        // TODO: Descomentar o método referente à estrutura de dados escolhida.

        //testArrayList();
        //testLinkedList();
        //testSortedList();
        //testStacks();
    }

    private static void testArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10, 5, 23, 19, 2, 7, 1);
        arrayList.add(0, 0);
        arrayList.remove(5);
        arrayList.remove(new Integer(7));

        System.out.println("Lista: " + arrayList);
        System.out.println("Tamanho: " + arrayList.size());
        System.out.println("Número na posição 1: " + arrayList.get(1));
        System.out.println("Indice do número 23: " + arrayList.indexOf(23));
        System.out.println("Contém 1: " + arrayList.contains(1));
        System.out.println("Contém 7: " + arrayList.contains(7));

        arrayList.clear();
        System.out.println("Lista limpa: " + arrayList);
    }

    private static void testLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(1, 1);
        linkedList.add(0);
        linkedList.add(2, 3);
        linkedList.remove(0);
        linkedList.remove(linkedList.size() - 1);
        linkedList.remove(new Integer(3));

        System.out.println("Lista: " + linkedList);
        System.out.println("Tamanho: " + linkedList.size());
        System.out.println("Número na posição 1: " + linkedList.get(1));
        System.out.println("Indice do número 1: " + linkedList.indexOf(1));
        System.out.println("Contém 10: " + linkedList.contains(10));
        System.out.println("Contém 3: " + linkedList.contains(3));

        linkedList.clear();
        System.out.println("Lista limpa: " + linkedList);
    }

    private static void testSortedList() {
        SortedList<Integer> sortedList = new SortedList<>();
        sortedList.add(5);
        sortedList.add(11);
        sortedList.add(3);
        sortedList.add(0);
        sortedList.add(8);
        sortedList.add(7);
        sortedList.add(3);
        System.out.println(sortedList);
    }

    private static void testStacks() {
        StackA<Integer> stackA = new StackA<>();
        StackL<Integer> stackL = new StackL<>();

        stackA.push(5);
        stackA.push(1);
        stackA.push(3);
        stackA.push(9);

        stackL.push(5);
        stackL.push(1);
        stackL.push(3);
        stackL.push(9);

        System.out.println(stackA);
        System.out.println(stackL);
    }
}
