package list;

import java.util.Objects;

public class DawidList<T> implements DawidCollectionList<T> {
    private Node<T> first;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        int size = 1;
        Node<T> n = first;
        while (n.next != null) {
            n = n.next;
            size += 1;
        }
        return size;
    }

    public T findAtIndex(int index) {

        if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Wrong index");
        }
        Node<T> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        System.out.println(n.value);
        return n.value;
    }

    public boolean listContains(T value) {
        Node<T> n = first;
        boolean checker = false;
        while (n.next != null) {
            System.out.println(n.value);
            System.out.println(value);
            System.out.println(checker);
            if (n.equals(new Node<>(value))) {
                System.out.println("posiada");
                return checker = true;
            }
            n = n.next;
        }
        System.out.println("nie posiada");
        return false;
    }


    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (first == null) {
            first = node;
            return;
        }
        node.next = first;
        first = node;
    }

    public void addLast(T value) {
        Node<T> n = first;
        Node<T> node = new Node<>(value);
        int counter = 0;
        if (first == null) {
            first = node;
            return;
        }
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
    }

    public void addAtIndex(T value, int index) {
        Node<T> node = new Node<>(value);
        Node<T> n = first;
        if (index > size() - 1 || index < 0) {
            System.out.println("wrong index");
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
            if (i == index - 2) {
                node.next = n.next;
                n.next = node;
            }
        }
    }


    public void removeAtIndex(int index) {
        Node n = first;
        if (index > size() - 1 || index < 0) {
            System.out.println("wrong index");
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            n = n.next;
            if (i == index - 2) {
                n.next = n.next.next;
            }
        }
    }

    public void removeFirst() {
        Node<T> tmp = first;
        first = first.next;
        tmp.setNext(null);
    }


    public void removeLast() {
        if (first == null) {
            System.out.println("Lista jest pusta");
            return;
        }
        Node n = first;
        if (n.next == null) {
            first = null;
            return;
        }
        while (n.next.next != null) {
            n = n.next;
        }
        n.setNext(null);
    }

    @Override
    public T getFromBegin() {
        if (first == null) {
            throw new NullPointerException("List is empty");
        }
        return first.value;
    }

    @Override
    public T getFromEnd() {
        if (first == null) {
            throw new NullPointerException("List is empty");
        }
        Node<T> node = first;
        while (node.next != null) {
            node = node.next;
        }
        return node.value;
    }

    @Override
    public T getFromIndex(int index) {
        if (first == null) {
            throw new NullPointerException("List is empty");
        } else if (index >= size() || index < 0) {
            throw new IllegalArgumentException("Wrong index");
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }


    @Override
    public String toString() {
        Node<T> n = first;
        StringBuilder sb = new StringBuilder("[");
        while (n.next != null) {
            sb = sb.append(n.value.toString()).append(", ");
            n = n.next;
        }
        sb = sb.append(n.value.toString()).append("]");
        return sb.toString();
    }


    private class Node<T> {

        T value;

        Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> node) {
            next = node;
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
