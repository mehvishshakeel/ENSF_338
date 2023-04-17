
package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SLLTest {

    private SLL sll;

    @Before
    public void setUp() throws Exception {
        sll = new SLL();
    }

    @Test
    public void testInsertHead() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.insertHead(node3);

        assertEquals(node3, sll.head);
        assertEquals(node1, sll.tail);
        assertEquals(3, sll.size);
    }

    @Test
    public void testInsertTail() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insertTail(node1);
        sll.insertTail(node2);
        sll.insertTail(node3);

        assertEquals(node1, sll.head);
        assertEquals(node3, sll.tail);
        assertEquals(3, sll.size);
    }

    @Test
    public void testInsert() throws Exception {
        SNode node1 = new SNode(1);
        sll.insert(node1, 0);
        assertEquals(sll.head, node1);
        assertEquals(sll.tail, node1);
        assertEquals(sll.size, 1);

        SNode node2 = new SNode(2);
        sll.insert(node2, 1);
        assertEquals(sll.head, node1);
        assertEquals(sll.tail, node2);
        assertEquals(sll.size, 2);

        SNode node3 = new SNode(3);
        sll.insert(node3, 1);
        assertEquals(sll.head, node1);
        assertEquals(sll.tail, node2);
        assertEquals(sll.size, 3);
        assertEquals(sll.head.getNext().getData(), 3);

        // Test out of bounds exception
        boolean exceptionThrown = false;
        try {
            sll.insert(node3, 5);
        } catch (Exception e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void testSortedInsert() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SNode node4 = new SNode(4);
        sll.sortedInsert(node3);
        sll.sortedInsert(node1);
        sll.sortedInsert(node4);
        sll.sortedInsert(node2);
        assertEquals(1, sll.head.getData());
        assertEquals(2, sll.head.getNext().getData());
        assertEquals(3, sll.head.getNext().getNext().getData());
        assertEquals(4, sll.head.getNext().getNext().getNext().getData());
        assertEquals(4, sll.size);
    }

    @Test
    public void testSearch() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.insertHead(node3);
        assertEquals(node2, sll.search(node2));
    }

    @Test
    public void testDeleteHead() throws Exception {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        SLL sll = new SLL(node1);
        sll.insertTail(node2);
        sll.insertTail(node3);
        assertEquals(3, sll.size);

        sll.deleteHead();
        assertEquals(2, sll.size);
        assertEquals(node2, sll.head);
        assertEquals(node3, sll.tail);
        assertEquals(node3, node2.getNext());

        sll.deleteHead();
        assertEquals(1, sll.size);
        assertEquals(node3, sll.head);
        assertEquals(node3, sll.tail);
        assertEquals(null, node3.getNext());

        sll.deleteHead();
        assertEquals(0, sll.size);
        assertEquals(null, sll.head);
        assertEquals(null, sll.tail);
    }

    @Test
    public void testDeleteTail() throws Exception {
        SNode node1 = new SNode(10);
        SNode node2 = new SNode(20);
        SNode node3 = new SNode(30);
        SLL sll = new SLL(node1);
        sll.insertTail(node2);
        sll.insertTail(node3);

        sll.deleteTail();

        assertEquals(2, sll.size);
        assertEquals(20, sll.tail.getData());
        assertNull(sll.tail.getNext());
    }

    @Test
    public void testDelete() throws Exception {
        SNode node1 = new SNode(10);
        SNode node2 = new SNode(20);
        SNode node3 = new SNode(30);
        SLL sll = new SLL(node1);
        sll.insertTail(node2);
        sll.insertTail(node3);

        sll.delete(node2);

        assertEquals(2, sll.size);
        assertEquals(10, sll.head.getData());
        assertEquals(30, sll.tail.getData());
    }

    @Test
    public void testSort() {
        SNode node1 = new SNode(30);
        SNode node2 = new SNode(10);
        SNode node3 = new SNode(20);
        SLL sll = new SLL(node1);
        sll.insertTail(node2);
        sll.insertTail(node3);

        sll.sort();

        assertEquals(10, sll.head.getData());
        assertEquals(30, sll.tail.getData());
        assertTrue(sll.isSorted);
    }

    @Test
    public void testClear() {
        SNode node1 = new SNode(10);
        SNode node2 = new SNode(20);
        SLL sll = new SLL(node1);
        sll.insertTail(node2);

        sll.clear();

        assertEquals(0, sll.size);
        assertNull(sll.head);
        assertNull(sll.tail);
        assertFalse(sll.isSorted);
    }

}
