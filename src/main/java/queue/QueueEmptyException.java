package queue;

public class QueueEmptyException extends RuntimeException {

    public QueueEmptyException() {
        super("Queue is empty");
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
