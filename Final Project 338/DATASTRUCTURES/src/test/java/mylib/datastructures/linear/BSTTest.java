package mylib.datastructures.linear;


import mylib.datastructures.trees.BST;
import org.junit.Test;

import static org.junit.Assert.*;


public class BSTTest {

    @Test
    public void testInsert() {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        assertEquals("20 30 40 50 60 70 80 ", tree.inOrderTraversalString());
    }

    @Test
    public void testDeleteLeaf() {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.delete(20);

        assertEquals("30 40 50 60 70 80 ", tree.inOrderTraversalString());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.delete(30);

        assertEquals("20 40 50 60 70 80 ", tree.inOrderTraversalString());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.delete(50);

        assertEquals("20 30 40 60 70 80 ", tree.inOrderTraversalString());
    }
}
