package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.DNode;

public class DLL {
    public DNode head;
    public DNode tail;
    public int size;

    
public DLL() {
    this.head = null;
    this.tail = null;
    this.size = 0;
    }

public DLL(DNode newNode) {
    this.head = newNode;
    this.tail = newNode;
    this.size = 1;
}

public void insertHead(DNode node) {
    if (head == null) {
        head = node;
        tail = node;
    } else {
        node.setNext(head);
        head.setPrev(node);
        head = node;
    }
    size++;
}

public void insertTail(DNode node) {
    if (tail == null) {
        head = node;
        tail = node;
    } else {
        node.setPrev(tail);
        tail.setNext(node);
        tail = node;
    }
    size++;
}

public void insert(DNode node, int position) throws Exception {
    if (position < 0 || position > size) {
        throw new Exception("Invalid position!");
    }
    if (position == 0) {
        insertHead(node);
    } else if (position == size) {
        insertTail(node);
    } else {
        DNode current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.getNext();
        }
        node.setPrev(current);
        node.setNext(current.getNext());
        current.getNext().setPrev(node);
        current.setNext(node);
        size++;
    }
}

public void sortedInsert(DNode node) {
    if (head == null) {
        head = node;
        tail = node;
        size++;
    } else if (node.getData() < head.getData()) {
        insertHead(node);
    } else if (node.getData() > tail.getData()) {
        insertTail(node);
    } else {
        DNode current = head;
        while (current.getNext() != null && current.getNext().getData() < node.getData()) {
            current = current.getNext();
        }
        node.setPrev(current);
        node.setNext(current.getNext());
        current.getNext().setPrev(node);
        current.setNext(node);
        size++;
    }
}

public void sort () {
    if (head == null) {
        System.out.println("List is empty!");
        return;
    }
    DNode current = head;
    while (current != null) {
        DNode next = current.getNext();
        while (next != null) {
            if (current.getData() > next.getData()) {
                int temp = current.getData();
                current.setData(next.getData());
                next.setData(temp);
            }
            next = next.getNext();
        }
        current = current.getNext();
    }
}

public void deleteHead() throws Exception {
    if (head == null) {
        throw new Exception("List is empty!");
    }
    head = head.getNext();
    if (head != null) {
        head.setPrev(null);
    } else {
        tail = null;
    }
    size--;
    
        
    }


public void deleteTail() throws Exception {
    if (tail == null) {
        throw new Exception("List is empty!");
        
    }
    tail = tail.getPrev();
    if (tail != null) {
        tail.setNext(null);
    } else {
        head = null;
    }
    size--;
}

public void delete(DNode node) throws Exception {
    if (head == null) {
        throw new Exception("List is empty!");
        
    }
    if (node == head) {
        deleteHead();
        
    } else if (node == tail) {
        deleteTail();

    } else {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        size--;
    }
}

public DNode search(int data) {
    DNode current = head;
    while (current != null) {
        if (current.getData() == data) {
            return current;
        }
        current = current.getNext();
    }
    return null;
}
public void print() {
    DNode current = head;
    while (current != null) {
        System.out.print(current.getData() + " ");
        current = current.getNext();
    }
    System.out.println();

}
}