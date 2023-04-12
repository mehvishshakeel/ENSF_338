package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.Linear.DLL;
import main.java.mylib.datastructures.nodes.DNode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DLLTest {

    private DLL dll;

    @Before
    public void setUp() throws Exception {
        dll = new DLL();
    }

    @Test
    public void testInsertHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.insertHead(node3);

        assertEquals(node3, dll.head);
        assertEquals(node1, dll.tail);
        assertEquals(3, dll.size);
    }

    @Test
    public void testInsertTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        dll.insertTail(node1);
        dll.insertTail(node2);
        dll.insertTail(node3);

        assertEquals(node1, dll.head);
        assertEquals(node3, dll.tail);
        assertEquals(3, dll.size);
    }

    @Test
    public void testInsert() throws Exception {
        DNode node1 = new DNode(1);
        dll.insert(node1, 0);
        assertEquals(dll.head, node1);
        assertEquals(dll.tail, node1);
        assertEquals(dll.size, 1);

        DNode node2 = new DNode(2);
        dll.insert(node2, 1);
        assertEquals(dll.head, node1);
        assertEquals(dll.tail, node2);
        assertEquals(dll.size, 2);

        DNode node3 = new DNode(3);
        dll.insert(node3, 1);
        assertEquals(dll.head, node1);
        assertEquals(dll.tail, node2);
        assertEquals(dll.size, 3);
        assertEquals(dll.head.getNext().getData(), 3);

        // Test out of bounds exception
        boolean exceptionThrown = false;
        try {
            dll.insert(node3, 5);
        } catch (Exception e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void testSortedInsert() {
        DNode node1 = new DNode(1);
        dll.sortedInsert(node1);
        assertEquals(dll.head, node1);
        assertEquals(dll.tail, node1);
        assertEquals(dll.size, 1);

        DNode node2 = new DNode(2);
        dll.sortedInsert(node2);
        assertEquals(dll.head, node1);
        assertEquals(dll.tail, node2);
        assertEquals(dll.size, 2);

        DNode node3 = new DNode(3);
        dll.sortedInsert(node3);
        assertEquals(dll.head, node1);
        assertEquals(dll.tail, node3);
        assertEquals(dll.size, 3);
    }

    @Test
    public void testSort() {
        DNode node1 = new DNode(3);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(1);
        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.insertHead(node3);
        dll.sort();
        assertEquals(dll.head, node3);
        assertEquals(dll.tail, node1);
        assertEquals(dll.size, 3);
    }

    @Test(expected = Exception.class)
    public void testInsertInvalidPosition() throws Exception {
        DLL list = new DLL();
        list.insert(new DNode(1), -1);
    }

    @Test
    public void testDeleteHead() throws Exception {
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        list.deleteHead();
        assertEquals(0, list.size);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test(expected = Exception.class)
    public void testDeleteHeadEmptyList() throws Exception {
        DLL list = new DLL();
        list.deleteHead();
    }

    @Test
    public void testDeleteTail() throws Exception {
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        list.deleteTail();
        assertEquals(0, list.size);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test(expected = Exception.class)
    public void testDeleteTailEmptyList() throws Exception {
        DLL list = new DLL();
        list.deleteTail();
    }

    @Test
    public void testDelete() throws Exception {
        DLL list = new DLL();

        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertTail(node1);
        list.insertTail(node2);
        list.insertTail(node3);
        list.delete(node1);
        assertEquals(2, list.size);
        assertEquals(2, list.head.getData());
        assertEquals(3, list.tail.getData());
    }

    @Test(expected = Exception.class)
    public void testDeleteInvalidPosition() throws Exception {
        DNode node1 = new DNode(-1);


        DLL list = new DLL();
        list.delete(node1);
    }

    @Test
    public void testPrint() {
        DLL list = new DLL();
        list.insertTail(new DNode(1));
        list.insertTail(new DNode(2));
        list.insertTail(new DNode(3));
        list.print();
    }

}
