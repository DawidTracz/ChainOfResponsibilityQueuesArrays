package queue;
import java.util.Objects;

public class FifoListQueue<T> implements Queue<T> {

    private Node<T> first;

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        int size = 1;
        Node<T> n = first;
        while (n.next != null) {
            n = n.next;
            size += 1;
        }
        return size;
    }

    @Override
    public void enqueue(T value) {
        Node<T> n = first;
        Node<T> node = new Node<>(value);
        if (first == null) {
            first = node;
            return;
        }
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }


    @Override
    public T dequeue()  {
        Node<T> n = first;
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        first = n.next;
        return n.value;
    }


    @Override
    public T front()  {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return first.value;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            throw  new  QueueEmptyException();
        }
        Node<T> n = first;
        StringBuilder sb = new StringBuilder("[");
        while (n.next != null) {
            if (n.value == null) {
                sb = sb.append("null").append(", ");
                n = n.next;
            } else {
                sb = sb.append(n.value.toString()).append(", ");
                n = n.next;
            }
        }
        sb = sb.append(n.value.toString()).append("]");
        return sb.toString();
    }


    private class Node<T> {

        T value;

        Node<T> next;

        private Node(T value) {
            this.value = value;
        }


        private T getValue() {
            return value;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> nodeQueue) {
            this.next = nodeQueue;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node)) {
                return false;
            }

            return Objects.equals(value, ((Node<T>) obj).value);

        }
    }
}
