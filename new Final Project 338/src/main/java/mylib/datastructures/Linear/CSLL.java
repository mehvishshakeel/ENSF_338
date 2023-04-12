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
        super.deleteHead();
        if (head.getNext() == tail) {
            tail.setNext(head);
        }

        if (head == null) {
            tail = null;
        }
        tail.setNext(head);
    }

    @Override
    public void deleteTail() {
        super.deleteTail();
        tail.setNext(head);
    }

    @Override
    public void delete(SNode node)  {
        super.delete(node);
        tail.setNext(head);
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
