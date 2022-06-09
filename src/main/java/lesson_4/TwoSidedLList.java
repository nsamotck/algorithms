package lesson_4;

import java.util.Iterator;

public class TwoSidedLList<E> implements LList<E>, Iterable<E> {

    protected int size;
    protected Node<E> first;
    protected Node<E> last;

    @Override
    public void insertFirst(E val) {
        if (this.isEmpty()) {
            first = last = new Node<>(val, null, null);
            size++;
        } else {
            Node<E> next = first;
            first = new Node<>(val, next, null);
            next.previous = first;
            size++;
        }
    }

    @Override
    public E getFirst() {
        return (this.first == null) ? null : this.first.val;
    }

    @Override
    public E removeFirst() {
        if (!this.isEmpty()) {
            E val = first.val;
            if (size == 1) {
                first = last = null;
                size--;
            } else {
                first = first.next;
                first.previous = null;
                size--;
            }
            return val;
        }
        return null;
    }

    @Override
    public void insertLast(E val) {
        if (this.isEmpty()) {
            last = first = new Node<>(val, null, null);
            size++;
        } else {
            Node<E> previous = last;
            last = new Node<>(val, null, previous);
            previous.next = last;
            size++;
        }
    }

    @Override
    public E getLast() {
        return (this.last == null) ? null : this.last.val;
    }

    @Override
    public E removeLast() {
        if (!this.isEmpty()) {
            E val = last.val;
            if (size == 1) {
                last = first = null;
                size--;
            } else {
                last = last.previous;
                last.next = null;
                size--;
            }
            return val;
        }
        return null;
    }

    @Override
    public boolean contains(E val) {
        Node<E> current = first;
        while (current != null) {
            if (current.val.equals(val)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean remove(E val) {
        Node<E> current = first;
        Node<E> prev;
        Node<E> next;
        while (current != null) {
            if (current.val.equals(val)) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == first) {
            removeFirst();
            return true;
        }
        if (current == last) {
            removeLast();
            return true;
        }

        prev = current.previous;
        next = current.next;
        prev.next = current.next;
        next.previous = current.previous;
        current.next = null;
        current.previous = null;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new TwoSidedLLIterator();
    }

    private class TwoSidedLLIterator implements Iterator<E> {
        private Node<E> current;
        private Node<E> next;

        TwoSidedLLIterator() {
            if (size == 0) {
                current = next = null; //throw new RuntimeException("Empty list: nothing to iterate");
                return;
            }
            current = first.previous;
            next = first;
        }

        @Override
        public boolean hasNext() {
            return !(next == null);
        }

        @Override
        public E next() {
            current = next;
            next = current.next;
            return current.val;
        }
    }
}