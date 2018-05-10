package list;

public interface DawidCollectionList<T> {


    boolean isEmpty();

    int size();

    T findAtIndex(int index);

    boolean listContains(T value);

    void addFirst(T value);

    void addLast(T value);

    void addAtIndex(T value, int index);

    void removeAtIndex(int index);

    void removeFirst();

    void removeLast();

    T getFromBegin();

    T getFromEnd();

    T getFromIndex(int index);
}