package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;
public class SLL {
    public SNode head;
    public SNode tail;
    public boolean isSorted=false;

    public int size;

    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public SLL(SNode newNode) {
        this.head = newNode;
        this.tail = newNode;
        this.size = 1;
    }

    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {

            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void insertTail(SNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void insert(SNode node, int position) throws IndexOutOfBoundsException {
        
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position!");

        }
        if (position == 0) {
            insertHead(node);

        } else if (position == size) {
            insertTail(node);

        } else {
            SNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            // current points to the node
            size++;
        }
    }

    public void sort() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        SNode current = head;
        while (current != null) {
            SNode next = current.getNext();
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
        isSorted = true;
    }

    public boolean isSorted() {
        SNode current = head;

        if (current == null) {
            return true;
        }
        SNode next = current.getNext();

        for (int i = 0; i < this.size - 1; i++) {
            if (current.getData() > next.getData()) {
                isSorted = false;
                return false;
            }
            current = current.getNext();
            next = current.getNext();
        }
        isSorted = true;
        return true;
    }

    public void sortedInsert(SNode node) {
        // acending order

        if (!isSorted()) {
            sort();
        }
        if (head == null || node.getData() < head.getData()) {
            insertHead(node);
            return;
        }
        SNode current = head;
        while (current.getNext() != null && current.getNext().getData() < node.getData()) {
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }

    public SNode search(SNode node) {
        SNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public void deleteHead() {
        if (head == null) {
            System.out.println("List is empty!");
            
            return;
        }
        head = head.getNext();
        size--;
        
        
        if (size == 0){
            tail = null;

        }
        

    }

    public void deleteTail() {
        if (tail == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }
        SNode current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        current.setNext(null);
        tail = current;
        size--;
    }

    public void delete(SNode node) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.getData() == node.getData()) {
            deleteHead();
            return;
        }
        if (tail.getData() == node.getData()) {
            deleteTail();
            return;
        }
        SNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData() == node.getData()) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    public void print(){
        System.out.print(size);
        System.out.print(isSorted);
        SNode current = this.head;
        while (current!= null) {
            
            System.out.print(current.getData());
            current = current.getNext();
        }
        System.out.println();
    }
    

}
