package src.test;

import org.junit.jupiter.api.Test;
import src.Stack.Stack;
import src.linked_list.Linked_List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class StackTest {

    @Test
    void can_get_resetTop() {
        Stack<String> stack_underTest = new Linked_List<>();
        //Test popping from an empty stack
        try{
            stack_underTest.peek();
            fail("Expect an Exception to be thrown");
        }catch(Exception e){
            assertThat("Peek attempt on empty stack");
        }
       // assertThat(stack_underTest.peek()).isEqualTo(null);
        stack_underTest.push("Adetunji");
        assertThat(stack_underTest.peek()).isEqualTo("Adetunji");

    }

    @Test
    void can_pushANDpop() {
        Stack<Integer> stack_underTest = new Linked_List<>();
        stack_underTest.setLimi(5);
        //Test popping from an empty stack
        try{
            stack_underTest.pop();
            fail("Expect an Exception to be thrown");
        }catch(Exception e){
            assertThat("Pop attempt on empty stack");
        }
        stack_underTest.push(230);
        stack_underTest.push(341);
        stack_underTest.push(400);

        //Test that pop returns the correct data from stack
        assertThat(stack_underTest.pop()).isEqualTo(400);

        //Test that stack top is reset after pop and top now points to the correct data
        assertThat(stack_underTest.peek()).isEqualTo(341);

        stack_underTest.push(23);
        stack_underTest.push(741);
        stack_underTest.push(481);

        //Test stackOverflow exception when try to push into full stack
        try{
            stack_underTest.push(999);
            fail("Expect an Exception to be thrown");
        }catch(Exception e){
            assertThat("Push attempt on full stack");
        }


    }

    @Test
    void can_CheckIsEmpty(){
        Stack <Character> istack_underTest = new Linked_List<>();
        assertThat(istack_underTest.isEmpty()).isTrue();
        istack_underTest.push('A');
        assertThat(istack_underTest.isEmpty()).isFalse();
    }
    @Test
    void can_getStackSize() {
        Stack <Integer> istack_underTest = new Linked_List<>();
        istack_underTest.push(230);
        istack_underTest.push(341);
        istack_underTest.push(400);
        assertThat(istack_underTest.size()).isEqualTo(3);

    }

}