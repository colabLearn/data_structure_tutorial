package src.test;


import org.junit.jupiter.api.Test;
import src.linked_list.Linked_List;
import src.linked_list.Node;

import static org.assertj.core.api.Assertions.*;

class Linked_ListTest {

    @Test
    void can_addFirst() {
        Linked_List<Integer> linkedListUnderTest = new Linked_List<Integer>();
     linkedListUnderTest.addFirst(100);
     assertThat(linkedListUnderTest.getHead()
                                         .getData())
                                         .isEqualTo(100);
     assertThat(linkedListUnderTest.size()).isEqualTo(1);

    }

    @Test
    void can_setAndGetHead() {
        Linked_List linkedListUnderTest = new Linked_List();
        Node<Integer> newNode = new Node<>(200);
        linkedListUnderTest.setHead(newNode);
        assertThat(linkedListUnderTest.getHead())
                                            .isEqualTo(newNode);
        assertThat(linkedListUnderTest.size()).isEqualTo(1);
    }


    @Test
    void can_addLast() {
        Linked_List<Integer> linkedListUnderTest = new Linked_List<Integer>();

        linkedListUnderTest.addLast(800);
        assertThat(linkedListUnderTest.getDataAt(linkedListUnderTest.size()-1))
                                            .isEqualTo(800);
        assertThat(linkedListUnderTest.size()).isEqualTo(1);
    }

    @Test
    void can_addAt(){
        Linked_List<Integer> linkedListUnderTest = new Linked_List<Integer>();
        linkedListUnderTest.addFirst(250);
        linkedListUnderTest.addLast(320);
        linkedListUnderTest.addFirst(80);
        linkedListUnderTest.addLast(440);

        //Try if it throws Exception when position is above size+1
        try{
            linkedListUnderTest.addAt(68, 6);
            fail("Expect an Exception to be thrown");
        }catch(Exception e){
            assertThat("Position to add is out of bound.");
        }
       //Try if addAt throws expected Exception if @parameter pos is <0
        try{
            linkedListUnderTest.addAt(910, -1);
            fail("Expect an Exception to be thrown");
        }catch (Exception e){
            assertThat("Cannot add to list: invalid position to add to.");
        }

        //Test if addAt adds at correct position when position is within LinkedList index bound.
        int pos = 3;
        linkedListUnderTest.addAt(145, pos);

        assertThat(linkedListUnderTest.getDataAt(pos)).isEqualTo(145);
        assertThat(linkedListUnderTest.size()).isEqualTo(5);
    }

    @Test
    void can_removeFirst(){
        Linked_List<String> linkedListUnderTest = new Linked_List<String>();

     //Test if removeFirst() throw exception if LinkedList is empty
        try{
            linkedListUnderTest.removeFirst();
            fail("Expect an Exception to be thrown");
        }catch (Exception e){
            assertThat("java.lang.Exception: Cannot remove from empty list!");
        }

        linkedListUnderTest.addLast("Tunji");
        linkedListUnderTest.addLast("Victor");
        linkedListUnderTest.addLast("Nathalii");
        linkedListUnderTest.addLast("Victoria");
        linkedListUnderTest.removeFirst();
        assertThat(linkedListUnderTest.getHead().getData()).isEqualTo("Victor");
        assertThat(linkedListUnderTest.size()).isEqualTo(3);
    }

    @Test
    void can_removeLast(){
        Linked_List<Integer> linkedListUnderTest = new Linked_List<>();

        //Test if removeLast() throw exception if LinkedList is empty
        try{
            linkedListUnderTest.removeFirst();
            fail("Expect an Exception to be thrown");
        }catch (Exception e){
            assertThat("java.lang.Exception: Cannot remove from empty list!");
        }

        linkedListUnderTest.addLast(250);
        linkedListUnderTest.addLast(320);
        linkedListUnderTest.addLast(80);
        linkedListUnderTest.addLast(440);

        linkedListUnderTest.removeLast();

        assertThat(linkedListUnderTest.getDataAt(linkedListUnderTest.size()-1)).isEqualTo(80);
        assertThat(linkedListUnderTest.size()).isEqualTo(3);
    }

    @Test
    void can_removeAt(){
        Linked_List<Integer> linkedListUnderTest = new Linked_List<Integer>();
        try{
            linkedListUnderTest.removeAt(2);
            fail("Expect an Exception to be thrown");
        }catch(Exception e){
            assertThat("java.lang.Exception: Cannot remove from empty list!");
        }
        linkedListUnderTest.addLast(250);
        linkedListUnderTest.addLast(320);
        linkedListUnderTest.addLast(80);
        linkedListUnderTest.addLast(440);

        try{
            linkedListUnderTest.removeAt(4);
            fail("Expect an Exception to be thrown");
        }catch(Exception e){
            assertThat("java.lang.Exception: position to remove from is out of bound!");
        }
        try{
            linkedListUnderTest.removeAt(-1);
            fail("Expect an Exception to be thrown");
        }catch(Exception e){
            assertThat("java.lang.Exception: position to remove from is out of bound!");
        }
        linkedListUnderTest.removeAt(2);
        assertThat(linkedListUnderTest.getDataAt(2)).isEqualTo(440);
        assertThat(linkedListUnderTest.size()).isEqualTo(3);
    }

    @Test
    void can_checkIsEmpty(){
        Linked_List<Integer> linkedListUnderTest = new Linked_List<Integer>();

        assertThat(linkedListUnderTest.isEmpty()).isTrue();


    }

    @Test
    void test_allMethodsWorksTogether(){
       Linked_List<Integer> linkedListUnderTest = new Linked_List<Integer>();

        linkedListUnderTest.addFirst(100);

        linkedListUnderTest.addLast(800);

         int pos1 = 0;
        linkedListUnderTest.addAt(925,pos1);

        int pos2 = linkedListUnderTest.size();
        linkedListUnderTest.addAt(777, pos2);

        int pos3 = 1;
        linkedListUnderTest.addAt(797, pos3);

        linkedListUnderTest.removeAt(2);

        linkedListUnderTest.removeLast();
        assertThat(linkedListUnderTest.size()).isEqualTo(3);

        linkedListUnderTest.removeFirst();
        assertThat(linkedListUnderTest.size()).isEqualTo(2);


        linkedListUnderTest.setHead(new Node<>(539));
        assertThat(linkedListUnderTest.size()).isEqualTo(3);
        assertThat(linkedListUnderTest.getHead().getData()).isEqualTo(539);

    }


}