package main.java.mylib.datastructures.Linear;

import main.java.mylib.datastructures.nodes.SNode;

public class QueueLL extends SLL{
    public QueueLL() {
        super();
    }
    public void enqueue(SNode node) {
        super.insertTail(node);
    }
    public SNode dequeue() throws Exception {

        if (head==null) {
            throw new Exception("Queue is empty");
        }

        SNode temp = super.head;
        super.deleteHead();
        return temp;
    

    
}

@Override
    public void insertHead(SNode node) {
    }

@Override
public void insert(SNode node, int position) throws IndexOutOfBoundsException {
}

@Override
public void sort() {
}
@Override
 public void sortedInsert(SNode node) {
 }

@Override 
public SNode search(SNode node) {
    return null;

}
@Override
public void deleteTail() {
}

@Override
public void delete(SNode node) {   

}

@Override
public void clear(){
}

@Override
public void print(){
}
}
