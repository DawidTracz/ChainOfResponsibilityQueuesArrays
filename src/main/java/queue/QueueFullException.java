package queue;

public class QueueFullException extends RuntimeException {
    public QueueFullException() {
        super("Queueu is full");
    }

    public QueueFullException(String message) {
        super(message);
    }
}
