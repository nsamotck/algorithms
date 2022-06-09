package lesson_4;

public class LLQueue<E> implements Queue<E> {
    private final TwoSidedLList<E> queue;

    public LLQueue() {
        this.queue = new TwoSidedLList<>();
    }

    @Override
    public boolean insert(E val) {
        queue.insertLast(val);
        return true;
    }

    @Override
    public E remove() {
        return queue.removeFirst();
    }

    @Override
    public E peekFront() {
        return queue.getFirst();
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        System.out.println(queue);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
