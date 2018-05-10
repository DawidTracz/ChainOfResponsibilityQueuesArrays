package queue;

public interface Queue<T> {

    boolean isEmpty();

    int size();

    void enqueue(T value);

    T dequeue() throws QueueEmptyException;

    T front() throws QueueEmptyException;
}
