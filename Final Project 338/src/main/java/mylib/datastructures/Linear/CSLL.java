package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {

    public CSLL() {
        super();
    }

    public CSLL(SNode node) {
        super(node);
        tail.setNext(head);
    }

    @Override
    public void insertHead(SNode node) {
        super.insertHead(node);
        tail.setNext(head);
    }

    @Override
    public void insertTail(SNode node) {
        super.insertTail(node);
        tail.setNext(head);
    }

    @Override
    public void insert(SNode node, int position) throws IndexOutOfBoundsException {
        
        super.insert(node, position);
        tail.setNext(head);
    }



    @Override
    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
            size--;
            return;
        }
        else {
            head = head.getNext();
            tail.setNext(head);
            size--;
        }
        if (size == 0) {
            tail = null;
            head = null;
            return;
        }
        else if (head == tail) {
            tail = head;
        }
    }

    @Override
    public void deleteTail() {
        super.deleteTail();
        tail.setNext(head);
    }

    @Override
    public void delete(SNode node)  {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head == node) {
            deleteHead();
            return;
        }
        if (tail == node) {
            deleteTail();
            return;
        }   
        SNode current = head;
        while (current.getNext()!= head) {
            if (current.getNext() == node) {
                current.setNext(node.getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void rotate(int k) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        for (int i = 0; i < k; i++) {
            head = head.getNext();
            tail = tail.getNext();
        }
    }
}
