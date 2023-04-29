package src.linked_list;

/**
 * AC12001/AC22007 Lab 1 Starting files
 *
 * @author Computing, School of Science and Engineering, University of Dundee.
 *		   Note. Change this to comment to describe this class and add your name!
 * @version v1.1
 */


public class Node <T> {
    // fields to store the data being held in this list node (a student object<-- name, id, age)
    protected T data;


    // TODO: Add a field to store a reference to the next node in the list after this one
    protected Node next;

    /**
     * Default constructor. Initialise fields to default values
     */
    public Node() {
        // set data (i.e. student object) to null
        data = null;

        // set next node to null
        next = null;

    }

    /**
     * Alternative constructor. Set fields to given values.
     *
     * @param inData an object of Student class that stores data(name, id, age)
     *
     */
    public Node(T inData) {
        data = inData;
        next = null;
    }

    /**
     * Get the data  contained in this list node
     *
     * @return The data, Student class  object that contains object's name, id and age
     */
    public T getData() {
        return data;
    }

    /**
     * Set the data in the list after this one
     *
     * @param data A reference to a Student object which
     *             stores name, id, age of the object.
     */

    public void setData(T data) {
        this.data = data;
    }


    /**
     * Get the next node in the list after this one
     *
     * @return A reference to the next node (or null if
     *         there is no next node)
     */
    public Node getNext() {
        return next;
    }

    /**
     * Set the next node in the list after this one
     *
     * @param next A reference to a ListNode object which
     *             represents the next node in the list after
     *             this one.
     */


    public void setNext(Node next) {

        this.next = next;
    }




    /**
     * toString method Overrides Java in built toString method
     *
     * @return Object of the list class as printable String.
     */



    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
