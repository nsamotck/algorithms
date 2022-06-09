package lesson_4;

public class Main {
    public static void main(String[] args) {
        TwoSidedLList<String> ll = new TwoSidedLList<>();

        System.out.println("first: " + ll.first);
        System.out.println("last: " + ll.last);
        System.out.println("is empty: " + ll.isEmpty());
        System.out.println("size: " + ll.size());
        System.out.println("get first: " + ll.getFirst());
        System.out.println("get last: " + ll.getLast());
        System.out.println("=========================");

        // add first element to the beginning
        ll.insertFirst("Hello_1");
        System.out.println("first: " + ll.first);
        System.out.println("last: " + ll.last);
        System.out.println("first prev: " + ll.first.previous);
        System.out.println("first next: " + ll.first.next);
        System.out.println("last prev: " + ll.last.previous);
        System.out.println("last next: " + ll.last.next);
        System.out.println("is empty: " + ll.isEmpty());
        System.out.println("size: " + ll.size());
        System.out.println("=========================");

        // add first element to the ending
        ll.insertLast("Hello_2");
        System.out.println("first: " + ll.first);
        System.out.println("last: " + ll.last);
        System.out.println("first prev: " + ll.first.previous);
        System.out.println("first next: " + ll.first.next);
        System.out.println("last prev: " + ll.last.previous);
        System.out.println("last next: " + ll.last.next);
        System.out.println("is empty: " + ll.isEmpty());
        System.out.println("size: " + ll.size());
        System.out.println("=========================");

        // remove all elements
        System.out.println("remove last: " + ll.removeLast());
        System.out.println("size: " + ll.size());
        System.out.println("first: " + ll.first);
        System.out.println("last: " + ll.last);
        System.out.println("remove last: " + ll.removeFirst());
        System.out.println("size: " + ll.size());
        System.out.println("first: " + ll.first);
        System.out.println("last: " + ll.last);
        System.out.println("=========================");

        // Queue test
        LLQueue<String> llQueue = new LLQueue<>();
        System.out.println("insert into queue: " + llQueue.insert("one"));
        System.out.println("insert into queue: " + llQueue.insert("two"));
        System.out.println("insert into queue: " + llQueue.insert("three"));
        System.out.println("peekFront: " + llQueue.peekFront());
        System.out.println("isEmpty: " + llQueue.isEmpty());
        System.out.println("print Queue: " + llQueue);
        System.out.println("remove: " + llQueue.remove());
        System.out.println("print Queue: " + llQueue);

    }
}
