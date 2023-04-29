package src.linked_list;

import java.util.Iterator;
import java.util.function.Consumer;

public class ListIterator<T> implements Iterator<T> {

        Node<T> current;

        public ListIterator(Linked_List<T> list){
            current =  new Node<T>(null);
            current.next=list.getHead();
        }

    @Override
    public boolean hasNext() {
        return current.next!=null;
    }

    @Override
    public T next() {
            current = current.next;
        return current.data;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action);
    }
}
