package main.java.mylib.datastructures.Linear;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import main.java.mylib.datastructures.nodes.SNode;

public class StackLLTest {

    @Test
    public void testPushAndPeek() {
        StackLL stack = new StackLL();
        assertNull(stack.peek());

        SNode node1 = new SNode(10);
        stack.push(node1);
        assertEquals(node1, stack.peek());

        SNode node2 = new SNode(20);
        stack.push(node2);
        assertEquals(node2, stack.peek());

        SNode node3 = new SNode(30);
        stack.push(node3);
        assertEquals(node3, stack.peek());
    }

    @Test
    public void testPop() throws Exception {
        StackLL stack = new StackLL();

        SNode node1 = new SNode(10);
        stack.push(node1);

        SNode node2 = new SNode(20);
        stack.push(node2);

        SNode node3 = new SNode(30);
        stack.push(node3);

        assertEquals(node3, stack.pop());
        assertEquals(node2, stack.pop());
        assertEquals(node1, stack.pop());
        assertNull(stack.pop());
    }

}
