package lesson_4;

public interface LList<E> {

    void insertFirst(E val);

    E getFirst();

    E removeFirst();

    void insertLast(E val);

    E getLast();

    E removeLast();

    boolean contains(E val);

    boolean remove(E val);

    boolean isEmpty();

    int size();

    class Node<E> {
        E val;
        Node<E> next;
        Node<E> previous;

        Node(E val, Node<E> next, Node<E> prevoius) {
            this.val = val;
            this.next = next;
            this.previous = prevoius;
        }

        @Override
        public String toString() {
            return "" + val + "";
        }
    }
}