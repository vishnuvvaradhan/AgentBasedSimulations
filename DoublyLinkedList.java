import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

    private static class Node<F> {
        F val;
        Node<F> prev, next;

        public Node(F v, Node<F> p, Node<F> n) {
            val = v;
            prev = p;
            next = n;
        }
    }

    private Node<E> first, last;
    private int size;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E getFirst() {
        if (first == null) throw new NoSuchElementException();
        return first.val;
    }

    public E getLast() {
        if (last == null) throw new NoSuchElementException();
        return last.val;
    }

    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item, null, first);
        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode;
        }
        first = newNode;
        size++;
    }

    public void addLast(E item) {
        Node<E> newNode = new Node<>(item, last, null);
        if (last != null) {
            last.next = newNode;
        } else {
            first = newNode;
        }
        last = newNode;
        size++;
    }

    public E removeFirst() {
        if (first == null) throw new NoSuchElementException();
        E val = first.val;
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        size--;
        return val;
    }

    public E removeLast() {
        if (last == null) throw new NoSuchElementException();
        E val = last.val;
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        size--;
        return val;
    }
}