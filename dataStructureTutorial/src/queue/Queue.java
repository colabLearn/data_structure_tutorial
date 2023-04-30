package src.queue;


public interface Queue <T> {


    void enqueue(T data);
    T dequeue();

    boolean isEmpty();

    boolean fullQueue();

    void increaseSize(int limit);

    void printInfo();

}
