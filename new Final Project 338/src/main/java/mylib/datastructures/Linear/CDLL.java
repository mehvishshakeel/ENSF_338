package main.java.mylib.datastructures.Linear;
import main.java.mylib.datastructures.nodes.DNode;
import java.util.NoSuchElementException;

public class CDLL {
    private DNode head;
    private DNode tail;
    private int size;

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

    public void addFirst(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        head.setPrev(tail);
        tail.setNext(head);
        size++;
    }

    public void addLast(int data) {
        DNode newNode = new DNode(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        head.setPrev(tail);
        tail.setNext(head);
        size++;
    }

    public void add(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        DNode newNode = new DNode(data);
        DNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.getPrev().setNext(newNode);
        newNode.setPrev(current.getPrev());
        newNode.setNext(current);
        current.setPrev(newNode);
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.getNext();
        head.setPrev(tail);
        tail.setNext(head);
        size--;
    }

    public void removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        tail = tail.getPrev();
        tail.setNext(head);
        head.setPrev(tail);
        size--;
    }
}