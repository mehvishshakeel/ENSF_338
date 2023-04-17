package mylib.datastructures.linear;

import mylib.datastructures.trees.AVL;

import org.junit.Test;

import static org.junit.Assert.*;

public class AVLTest {

    @Test
    public void testInsert() {
        AVL tree = new AVL();
        int[] values = {5, 2, 9, 1, 0, -1, 6, 10, 11};
    
        for (int value : values) {
            tree.insert(value);
        }
    
        assertEquals("-1 0 1 2 5 6 9 10 11 ", tree.inOrderTraversalString());
    }
    
    @Test
    public void testDelete() {
        AVL tree = new AVL();
        int[] values = {5, 2, 9, 1, 0, -1, 6, 10, 11};
    
        for (int value : values) {
            tree.insert(value);
        }
    
        tree.delete(10);
        assertEquals("-1 0 1 2 5 6 9 11 ", tree.inOrderTraversalString());
    }
    
    @Test
    public void testDeleteRoot() {
        AVL tree = new AVL();
        int[] values = {5, 2, 9, 1, 0, -1, 6, 10, 11};
    
        for (int value : values) {
            tree.insert(value);
        }
    
        tree.delete(5);
        assertEquals("-1 0 1 2 6 9 10 11 ", tree.inOrderTraversalString());
    }
    
    @Test
    public void testDeleteNodeWithTwoChildren() {
        AVL tree = new AVL();
        int[] values = {5, 2, 9, 1, 0, -1, 6, 10, 11};
    
        for (int value : values) {
            tree.insert(value);
        }
    
        tree.delete(2);
        assertEquals("-1 0 1 5 6 9 10 11 ", tree.inOrderTraversalString());
    }
    
}
