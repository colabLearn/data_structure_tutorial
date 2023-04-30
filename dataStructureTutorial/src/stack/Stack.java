package src.stack;

public interface Stack <T> {


    T peek();

    void push(T data);

    T pop();

    boolean isEmpty();

    int size();

    boolean stackIsFull();

    void increaseSize(int limit);

    void printStack();

}
