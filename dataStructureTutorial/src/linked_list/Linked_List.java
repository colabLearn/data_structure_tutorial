package src.linked_list;


import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Linked_List<T> implements Iterable<T> {

    private int length =  0;
    private Node head; // used to hold a reference to an instance of a ListNode object
    // which will be the first item in the list, i.e. at the 'head'
    // of the list
    /**
     * Default constructor. Initialise fields to default values.
     */
    public Linked_List() {
        // set the list to be empty, i.e. not referring to anything valid yet
        head = null;

    }
    /**
     * Get the list node which is at the 'head' of the list
     *
     * @return A reference to a ListNode object which represents the node at the
     *         head of the list (or null if the list is empty, i.e. no 'head' has
     *         been set yet).
     */

    public Node getHead() {
        return head;
    }
    /**
     * Set the 'head' of the list to the given node
     *
     * @param  newHead A reference to a ListNode object which will be
     *                 the head of the list.
     *
     * NOTE: if a list already exists, the existing listing will be
     * lost since the head is being assigned to something new.
     */

    public void setHead(Node newHead) {
        this.head = newHead;
        length++;
    }

    /**
     * Add a new node to the start of the list which will contain
     * the data provided (a student object<-- name, id, age).
     * NOTE: This method has deliberate bugs in it - can you use the debugger to
     * see what is going wrong?
     *
     * @param data The student object  to be added into the List
     *
     */

    public void addFirst(T data){
        Node newHead = new Node(data);
        /*
         * This method add data to the head of the list
         * i.e. @parameter inputs into the method becomes
         * the data in the first Node of your LinkedList
         */
        if (!isEmpty()) {
            /*
             * If newNode is not empty set points to the current head
             * Then, the head now points to the newHead.
             */
            newHead.setNext(head);

        }
        head = newHead;
        length++;
    }

    /**
     * Add a new-node to the end of the list. new-node contain
     * the data provided (Student object).
     * This method checks if List is empty to add new-node to head or
     * if List already has some node so add new-node to end of the list
     * NOTE: This method has deliberate bugs in it - can you use the debugger to
     * see what is going wrong?
     *
     * @param data The student object  to be added into the List
     *
     */
    public void addLast(T data){
        /*
         * This method add data to the end of your LinkedList
         * i.e. @parameter input into the method becomes the data
         * in the last Node of your list.
         */
        Node newNode = new Node();
        newNode.setData(data);
        /*
         * The check if the list is empty
         * If it is empty, the list head is set to point to the
         * newNode.
         */
        if(isEmpty()){
            head = newNode;
        }else{
            /*
             * Travers the list to the end
             */
            Node lastNode = head;
            while(lastNode.getNext()!=null){
                lastNode = lastNode.getNext();
            }
            //Add newNode to list, by lastNode next field pointing to newNode
            lastNode.setNext(newNode);
        }
        length++;
    }


    public int size(){
        /*
         * This method simply return the length/size of your LinkeList
         */
        return length;}

    public void addAt(T data, int pos){
        /*
         * @parameter: 2 --> data, post
         * @return: none
         * addAt--> adds data to your Linked list at position pos
         *           --> if position pos is less than 0
         *               : method throw exception and return message: "Cannot add to position less than 0."
         *           -->if position pos is greater than the size of your LinkedList
         *              : method throw exception and return message: "Position to add is out of bound."
         *           NOTE: Your method should take care of the Exceptions and do not expect exceptions to be taking
         *                  care of during method call!!!
         *           -->if position pos is equal to 0
         *              : method adds to beginning of LinkedList
         *           -->if position pos is equal to size of LinkedList
         *              : method adds to end of LinkedList
         *              --->else
         *                  :method adds to the LinkedList at position pos
         * NOTE: This method adds a new Node to your LinkedList, thus increase the length of your list when data
         *       is successfully added at position pos.
         */

        if(pos<0){
            try {
                throw new invalidListPosition();
                //throw new  Exception("Cannot add to position less than 0.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(pos>this.length){
            try {
                throw new outOfBoundPosition();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(pos==0){
            this.addFirst(data);

        }else if(pos==this.length){
            this.addLast(data);

        }else{
            Node current = this.head;
            for (int i = 1; i < pos; i++) {
                current = current.getNext();
            }


            Node newNode = new Node(data);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            length++;
        }
    }
    public T getDataAt(int pos) {
        Node current = this.head;
        if(pos<0| pos>this.length-1){
            try {
                throw new Exception("index out of bound!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(isEmpty()){
            try {
                throw new Exception("Cannot get data from empty list!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{

            for (int i = 0; i < pos ; i++) {
                current = current.next;
            }
        }
        return (T) current.getData();
    }

    public void removeFirst(){
        /*
         * Remove the first Node ( and data) from your LinkedList
         * This method shrinks your LinkedList
         * i.e. if successfully called it reduces the length of your list by 1
         * Note: method throws an Exception if LinkedList is empty
         *     --> return message: "Cannot remove from empty list!"
         */
        if(!isEmpty()){
            this.head = head.getNext();
            length--;

        }else{
            try {
                throw new Exception("Cannot remove from empty list!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void removeLast(){
        /*
         * @Parameter: 0
         * @return: none
         * Remove the first Node ( and data) from your LinkedList
         * This method shrinks your LinkedList
         * i.e. if successfully called it reduces the length of your list by 1
         * Note: method throws an Exception if LinkedList is empty
         *     --> return message: "Cannot remove from empty list!"
         */

        if(!isEmpty()){
            Node current = this.head;
            while(current.getNext()!=null&& current.next.next!=null){
                current = current.getNext();
            }
            current.next = null;
            this.length--;
        }else{
            try {
                throw new Exception("Cannot remove from empty list!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void removeAt(int pos){
        //Remove the Node (data) at position pos
        /*
         * Note: LinkedList does not automatically shring when data is deleted from it.
         * When an element is removed from a LinkedList, the size of the LinkedList remains the same
         * but the deleted element (data) is no longer accessible from the list.
         */
        //if pos is less than 0 or greater than size-1
        //Method throw exception: return statemen--> index out of bound!
        if(isEmpty()){
            try {
                throw new Exception("Cannot remove from empty list!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if(pos<0 | pos>length-1){
            try {
                throw new Exception("position to remove from is out of bound!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (pos==0) {
            head = head.getNext();
        } else {

            Node current = head;
            Node prev = null;
            for (int i = 0; i < pos; i++) {
                prev = current;
                current = current.getNext();
            }
            if(current!=null){
                prev.setNext(current.getNext());
                this.length--;
            }


        }
    }

    public boolean isEmpty(){

        return head==null;
    }

    @Override
    public String toString() {
        return "Linked_List{" +
                "head=" + head +
                '}';
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
