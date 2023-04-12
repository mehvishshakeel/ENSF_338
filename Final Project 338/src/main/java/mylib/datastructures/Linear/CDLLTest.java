package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CDLLTest {

    private CDLL cdll;

    @Before
    public void setUp() throws Exception {
        cdll = new CDLL();
    }

    @Test
    public void testInsertHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        cdll.insertHead(node1);
        cdll.insertHead(node2);
        cdll.insertHead(node3);

        assertEquals(node3, cdll.head);
        assertEquals(node1, cdll.tail);
        assertEquals(3, cdll.size);
    }

    @Test
    public void testInsertTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        cdll.insertTail(node1);
        cdll.insertTail(node2);
        cdll.insertTail(node3);

        assertEquals(node1, cdll.head);
        assertEquals(node3, cdll.tail);
        assertEquals(3, cdll.size);
    }

    @Test
    public void testInsert() throws Exception {
        DNode node1 = new DNode(1);
        cdll.insert(node1, 0);
        assertEquals(cdll.head, node1);
        assertEquals(cdll.tail, node1);
        assertEquals(cdll.size, 1);

        DNode node2 = new DNode(2);
        cdll.insert(node2, 1);
        assertEquals(cdll.head, node1);
        assertEquals(cdll.tail, node2);
        assertEquals(cdll.size, 2);

        DNode node3 = new DNode(3);
        cdll.insert(node3, 1);
        assertEquals(cdll.head, node1);
        assertEquals(cdll.tail, node2);
        assertEquals(cdll.size, 3);
        assertEquals(cdll.head.getNext().getData(), 3);

        // Test out of bounds exception
        boolean exceptionThrown = false;
        try {
            cdll.insert(node3, 5);
        } catch (Exception e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void testSortedInsert() {
        DNode node1 = new DNode(1);
        cdll.sortedInsert(node1);
        assertEquals(cdll.head, node1);
        assertEquals(cdll.tail, node1);
        assertEquals(cdll.size, 1);

        DNode node2 = new DNode(2);
        cdll.sortedInsert(node2);
        assertEquals(cdll.head, node1);
        assertEquals(cdll.tail, node2);
        assertEquals(cdll.size, 2);

        DNode node3 = new DNode(3);
        cdll.sortedInsert(node3);
        assertEquals(cdll.head, node1);
        assertEquals(cdll.tail, node3);
        assertEquals(cdll.size, 3);
    }

    @Test
    public void testDeleteHead() throws Exception {
        CDLL list = new CDLL();
        list.insertTail(new DNode(1));
        list.deleteHead();
        assertEquals(0, list.size);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test(expected = Exception.class)
    public void testDeleteHeadEmptyList() throws Exception {
        CDLL list = new CDLL();
        list.deleteHead();
    }

    @Test
    public void testDeleteTail() throws Exception {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.deleteTail();
        assertEquals(2, list.size);
        assertEquals(node1, list.head);
        assertEquals(node2, list.tail);
        assertEquals(node1, list.tail.getPrev());
        assertEquals(node2, list.head.getNext());
        assertEquals(list.head, list.tail.getNext());
        assertEquals(list.tail, list.head.getPrev());

        // Test deleting tail from list with one node
        CDLL list2 = new CDLL(node1);
        list2.deleteTail();
        assertEquals(0, list2.size);
        assertNull(list2.head);
        assertNull(list2.tail);
    }

    @Test(expected = Exception.class)
    public void testDeleteTailEmptyList() throws Exception {
        CDLL list = new CDLL();

        list.deleteTail();
     }
}
