package src.Stack;

public interface Stack <T> {


    T peek();

    void push(T data);

    T pop();

    boolean isEmpty();

    int size();

    boolean stackIsFull();

    void setLimi(int limit);

    void printStack();

}
