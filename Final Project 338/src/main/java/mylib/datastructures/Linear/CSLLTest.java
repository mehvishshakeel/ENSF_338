package main.java.mylib.datastructures.Linear;

import org.junit.Before;
import org.junit.Test;

import main.java.mylib.datastructures.nodes.SNode;

import static org.junit.Assert.*;

public class CSLLTest {

    @Test
    public void testInsertHead() {
        CSLL sll = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.insertHead(node1);
        assertEquals(node1, sll.head);
        assertEquals(node1, sll.tail);

        sll.insertHead(node2);
        assertEquals(node2, sll.head);
        assertEquals(node1, sll.tail);
    }

    @Test
    public void testInsertTail() {
        CSLL sll = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.insertTail(node1);
        assertEquals(node1, sll.head);
        assertEquals(node1, sll.tail);

        sll.insertTail(node2);
        assertEquals(node1, sll.head);
        assertEquals(node2, sll.tail);
    }

    @Test
    public void testInsert() throws Exception {
        CSLL sll = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insert(node1, 0);
        assertEquals(node1, sll.head);
        assertEquals(node1, sll.tail);

        sll.insert(node2, 1);
        assertEquals(node1, sll.head);
        assertEquals(node2, sll.tail);

        sll.insert(node3, 1);
        assertEquals(node1, sll.head);
        assertEquals(node3, node1.getNext());
        assertEquals(node1, node2.getNext());
        assertEquals(node2, sll.tail);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOfBounds() throws Exception {
        CSLL sll = new CSLL();
        SNode node1 = new SNode(1);

        sll.insert(node1, 1);
    }

    @Test
    public void testDeleteHead() throws Exception {
        CSLL sll = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.insertHead(node3);

        sll.deleteHead();
        assertEquals(node2, sll.head);
        assertEquals(node1, sll.tail);
        sll.deleteHead();
        assertEquals(node1, sll.head);
        assertEquals(node1, sll.tail);
        assertEquals(sll.head, node1.getNext());
    }

    @Test
    public void testDeleteTail() throws Exception {
        CSLL sll = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);

        sll.insertHead(node1);
        sll.insertHead(node2);

        sll.deleteTail();
        assertEquals(node2, sll.head);
        assertEquals(sll.head, node1.getNext());
    }

    @Test
    public void testDelete() throws Exception {
        CSLL sll = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);

        sll.insertHead(node1);
        sll.insertHead(node2);
        sll.insertHead(node3);

        // Delete middle node
        sll.delete(node2);
        assertEquals(node3, sll.head);
        assertEquals(node1, sll.tail);
        assertEquals(node3, node1.getNext());
        assertEquals(2, sll.size);

        // Delete head node
        sll.delete(node3);
        assertEquals(node1, sll.head);
        assertEquals(node1, sll.tail);
        assertEquals(sll.head, node1.getNext());
        assertEquals(1, sll.size);

        // Delete tail node
        sll.delete(node1);
        assertNull(sll.head);
        assertNull(sll.tail);
        assertEquals(0, sll.size);
    }

}