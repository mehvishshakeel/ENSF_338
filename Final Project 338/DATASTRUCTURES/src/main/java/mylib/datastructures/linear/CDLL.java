package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

import java.util.NoSuchElementException;

public class CDLL  extends DLL{
    public DNode head;
    public DNode tail;
    public int size;

    public CDLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public CDLL(DNode node) {
        head = node;
        tail = node;
        head.setNext(tail);
        tail.setPrev(head);
        size = 1;
    }

    public void insertHead(DNode node) {

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            node.setNext(node);
            node.setPrev(node);
        } else {
            node.setPrev(this.tail);
            node.setNext(this.head);
            this.head.setPrev(node);
            this.tail.setNext(node);
            this.head = node;
        }
        this.size++;
    }

        
    

    public void insertTail(DNode node) {
        if (this.tail == null) {
            this.insertHead(node);
        } else {
            node.setPrev(this.tail);
            node.setNext(this.head);
            this.head.setPrev(node);
            this.tail.setNext(node);
            this.tail = node;
            this.size++;
        }
    }

    public void sortedInsert(DNode node) {
        if (this.head == null) {
            this.insertHead(node);
        } else {
            DNode current = this.head;
            while (current.getNext() != this.head && node.getData() > current.getData()) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            node.setPrev(current);
            this.tail = node;
            this.size++;
            current.setNext(node);
        }
    

        // if (this.head == null) {
        //     this.insertHead(node);
        // } 
        // else {
        //     DNode current = this.head;
        //     while (current.getNext() != this.head && node.getData() > current.getData()) {
        //         current = current.getNext();
        //     }
        //     node.setNext(current.getNext());
        //     node.setPrev(current);
        //     // current.setNext(node);
        // }
    }

    public void insert(DNode node, int index) throws Exception {
        if (index < 0 || index > this.size) {
            throw new Exception("Index out of bounds.");
        }
        if (index == 0) {
            this.insertHead(node);
        } else if (index == this.size) {
            this.insertTail(node);
        } else {
            DNode current = this.head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
            this.size++;
        }
    }

    public void remove(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        DNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        if (current == head) {
            head = head.getNext();
        }
        if (current == tail) {
            tail = tail.getPrev();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
    }

    public void deleteHead() throws Exception {
        if (this.head == null) {
            throw new Exception("List is empty");
        }
        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrev(this.tail);
            this.tail.setNext(this.head);
        }
        this.size--;
    }

    public void remove(DNode node) throws NoSuchElementException {
        if (size == 1 && node == head) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
    }

    public void deleteTail() throws Exception {
        if (this.tail == null) {
            throw new Exception("List is empty");
        }
        if (this.tail == this.head) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrev();
            this.tail.setNext(this.head);
            this.head.setPrev(this.tail);
        }
        this.size--;
    }  
      
    // public void testDeleteTailEmptyList() throws Exception {
    //     CDLL list = new CDLL();
    //     try {
    //         list.deleteTail();
    //         fail("Should have thrown an exception");
    //     } catch (Exception e) {
    //         assertEquals("List is empty", e.getMessage());
    //     }
    // }

    // private void assertEquals(String string, String message) {
    // }

    // private void fail(String string) {
    // }


    // public void add(int index, int data) {
    //     if (index < 0 || index > size) {
    //         throw new IndexOutOfBoundsException("Invalid index");
    //     }
    //     if (index == 0) {
    //         addFirst(data);
    //         return;
    //     }
    //     if (index == size) {
    //         addLast(data);
    //         return;
    //     }
    //     DNode newNode = new DNode(data);
    //     DNode current = head;
    //     for (int i = 0; i < index; i++) {
    //         current = current.getNext();
    //     }
    //     current.getPrev().setNext(newNode);
    //     newNode.setPrev(current.getPrev());
    //     newNode.setNext(current);
    //     current.setPrev(newNode);
    //     size++;
    // }

    // public void removeFirst() {
    //     if (head == null) {
    //         throw new NoSuchElementException("List is empty");
    //     }
    //     head = head.getNext();
    //     head.setPrev(tail);
    //     tail.setNext(head);
    //     size--;
    // }

    // public void removeLast() {
    //     if (tail == null) {
    //         throw new NoSuchElementException("List is empty");
    //     }
    //     tail = tail.getPrev();
    //     tail.setNext(head);
    //     head.setPrev(tail);
    //     size--;
    // }
}
