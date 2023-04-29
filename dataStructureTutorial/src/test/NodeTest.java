package src.test;


import src.linked_list.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeTest {

    Node nodeUnderTest = new Node<>(36);

    @Test
    void can_getData() {
        assertEquals(nodeUnderTest.getData(), 36);
    }

    @org.junit.jupiter.api.Test
    void can_setData() {
        String[] names = new String[]{"Tunji", "Ade", "Tolu"};
        String name = "Nataliia";
        nodeUnderTest.setData(names);
        assertEquals(nodeUnderTest.getData(),names);
    }

    @org.junit.jupiter.api.Test
    void can_getNext() {

        assertEquals(nodeUnderTest.getNext(),null);
    }

    @org.junit.jupiter.api.Test
    void can_setNext() {
        Node newNodeUnderTest = new Node(54);
        nodeUnderTest.setNext(newNodeUnderTest);
        assertEquals(nodeUnderTest.getNext().getData(), 54);
    }
}