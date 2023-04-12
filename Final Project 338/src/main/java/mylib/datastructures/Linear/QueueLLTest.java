package main.java.mylib.datastructures.Linear;

import static org.junit.Assert.*;
import org.junit.Test;
import main.java.mylib.datastructures.nodes.SNode;

public class QueueLLTest {

    @Test
    public void testEnqueueAndDequeue() throws Exception {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        // enqueue three nodes
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);

        // dequeue three nodes and check if they are correct
        assertEquals(node1, queue.dequeue());
        assertEquals(node2, queue.dequeue());
        assertEquals(node3, queue.dequeue());

        // dequeue from empty queue and check if it throws an exception
        boolean exceptionThrown = false;
        try {
            queue.dequeue();
        } catch (Exception e) {
            exceptionThrown = true;
            assertEquals("Queue is empty", e.getMessage());
        }
        assertTrue(exceptionThrown);
    }

    
}
