package lesson_3;

import java.io.File;
import java.io.IOException;

public class Main {
    private static class Stack {
        private int maxSize; // размер
        private int[] stack; // место хранения
        private int head;    // вершина

        public Stack(int size) {
            this.maxSize = size;
            this.stack = new int[this.maxSize];
            this.head = -1;
        }

        public boolean isEmpty() {
            return this.head == -1;
        }

        public boolean isFull() {
            return this.head == this.maxSize - 1;
        }

        public void push(int i) {
            if (isFull()) {
                this.maxSize *= 2;
                int[] newStack = new int[this.maxSize];
                System.arraycopy(this.stack, 0, newStack, 0, this.stack.length);
                this.stack = newStack;
            }
            this.stack[++this.head] = i;
        }

        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack is empty"); //ret -1
            return this.stack[this.head--];
        }

        public int peek() {
            return this.stack[this.head];
        }
    }

    private static class Queue {
        private int maxSize; // размер
        private int[] queue; // место хранения
        private int head;    // отсюда уходят
        private int tail;    // сюда приходят
        private int items;   // текущее количество

        public Queue(int s) {
            maxSize = s;
            queue = new int[maxSize];
            head = 0;
            tail = -1;
            items = 0;
        }

        public boolean isEmpty() {
            return (items == 0);
        }

        public boolean isFull() {
            return (items == maxSize);
        }

        public int size() {
            return items;
        }

        public void insert(int i) {
            if (isFull()) {
                maxSize *= 2;
                int[] tmpArr = new int[maxSize];
                if (tail >= head) {
                    System.arraycopy(queue, 0, tmpArr, 0, queue.length);
                } else {
                    System.arraycopy(queue, 0, tmpArr, 0, tail + 1);
                    System.arraycopy(queue, head, tmpArr,
                            maxSize - (queue.length - head), queue.length - head);
                    head = maxSize - (queue.length - head); // corrected
                }
                queue = tmpArr; // added
            }
            if (tail == maxSize - 1) {
                tail = -1;
            }
            queue[++tail] = i;
            ++items;
        }

        public int remove() {
            int temp = queue[head++];
            head %= maxSize;
            items--;
            return temp;
        }

        public int peek() {
            return queue[head];
        }
    }

    /**
     * Реализация Deque
     */
    private static class Deque {
        private int maxSize;
        private int[] deque;
        private int head;
        private int tail;
        private int items;

        public Deque(int s) {
            maxSize = s;
            deque = new int[maxSize];
            head = maxSize / 2; // первоначальная "голова" располагается примерно по середиен массива
            tail = head - 1;
            items = 0;
        }

        public boolean isEmpty() {
            return (items == 0);
        }

        public boolean isFull() {
            return (items == maxSize);
        }

        public int size() {
            return items;
        }

        public void insertRight(int i) {
            if (isFull()) {
                maxSize *= 2;
                int[] tmpArr = new int[maxSize];
                if (tail >= head) {
                    // ((maxSize / 2) - (deque.length / 2)) - располагаем старый массив примерно по центру нового
                    System.arraycopy(deque, 0, tmpArr, ((maxSize / 2) - (deque.length / 2)), deque.length);
                    head = (maxSize / 2) - (deque.length / 2);
                    tail = head + (deque.length - 1);
                } else {
                    System.arraycopy(deque, 0, tmpArr, 0, tail + 1);
                    System.arraycopy(deque, head, tmpArr,
                            maxSize - (deque.length - head), deque.length - head);
                    head = maxSize - (deque.length - head);
                }
                deque = tmpArr;
            }
            if (tail == maxSize - 1) {
                tail = -1;
            }
            deque[++tail] = i;
            ++items;
        }

        public void insertLeft(int i) {
            if (isFull()) {
                maxSize *= 2;
                int[] tmpArr = new int[maxSize];
                if (head <= tail) {
                    // ((maxSize / 2) - (deque.length / 2)) - располагаем старый массив примерно по центру нового
                    System.arraycopy(deque, 0, tmpArr, ((maxSize / 2) - (deque.length / 2)), deque.length);
                    head = (maxSize / 2) - (deque.length / 2);
                    tail = head + (deque.length - 1);
                } else {
                    System.arraycopy(deque, 0, tmpArr, 0, tail + 1);
                    System.arraycopy(deque, head, tmpArr, maxSize - (deque.length - head), (deque.length - head));
                    head = maxSize - (deque.length - head);
                }
                deque = tmpArr;
            }
            if (head == 0) {
                head = maxSize;
            }
            deque[--head] = i;
            ++items;
        }

        public int removeRight() {
            if (isEmpty()) throw new RuntimeException("Deque is empty");
            int temp = deque[tail--];
            --items;
            if (tail < 0 && !isEmpty()) { // если tail < 0 и deque ещё не пуста, то переводим tail в конец массива
                tail = maxSize - 1;
            } else if (tail < 0 && isEmpty()) { // если tail < 0 и deque пуста, то сбрасываем индексы head и tail в первоначальное состояние
                head = maxSize / 2;
                tail = head - 1;
            }
            return temp;
        }

        public int removeLeft() {
            if (isEmpty()) throw new RuntimeException("Deque is empty");
            int temp = deque[head++];
            --items;
            if (head == maxSize && !isEmpty()) { // если head достиг mazSize и deque ещё не пуста, то переводим head в начало массива
                head = 0;
            } else if (head == maxSize && isEmpty()) { // если head достиг mazSize и deque пуста, то сбрасываем индексы head и tail в первоначальное состояние
                head = maxSize / 2;
                tail = head - 1;
            }
            return temp;
        }
    }

    public static void main(String[] args) throws IOException {
        // Демо класса BracketAnalyzer.java
        File normalFile = new File("src/main/resources/lesson_3/Main.java");
        File erroneousFile = new File("src/main/resources/lesson_3/Error.java");
        BracketAnalyzer.initialize();
        BracketAnalyzer.checkFile(normalFile);
        System.out.println("File \"" + normalFile.getName() + "\" OK");
        try {
            BracketAnalyzer.checkFile(erroneousFile);
        } catch (RuntimeException e) {
            System.out.println("File \"" + erroneousFile.getName() + "\" NOK: " + e.getMessage());
            System.out.println("Stack is empty: " + BracketAnalyzer.getStack().empty());
        }
    }
}

// public static void check(String input) {...}
