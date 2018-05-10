package queue;

public class LifoArrayQueue<T> implements Queue<T> {

    private static final int DEFAULT_SIZE = 10;

    private int size = 0;
    private T[] queue;


    public LifoArrayQueue() {
        this(DEFAULT_SIZE);
    }

    public LifoArrayQueue(int length) {
        queue = (T[]) new Object[length];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(T value) {
        if (size == queue.length) {
            T[] newQueue = (T[]) new Object[(int) (size * 1.75)];
            System.arraycopy(queue, 0, newQueue, 0, size);
            queue = newQueue;
        }
        queue[size] = value;
        size += 1;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        T dequeueElement = queue[size - 1];
        size -= 1;
        queue[size] = null;

        return dequeueElement;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        return queue[size - 1];
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return  "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (queue[i] == null) {
                sb.append("null");
            } else {
                sb.append(queue[i].toString());
            }
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }

}
