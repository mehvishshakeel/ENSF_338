package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class StackLL extends SLL{
   
    public StackLL() {
        super();
    }

    public SNode peek() 
    {
        return super.head;
    }
    
    public SNode pop(){
        
        SNode temp = super.head;
        super.deleteHead();
        return temp;
    }

    public void push(SNode node)
    {
        super.insertHead(node);
    }

    @Override
    public void insertTail(SNode node){} 

    @Override
    public void insert(SNode node, int position) throws IndexOutOfBoundsException {
    }
    @Override
    public void sort() {
    }

    @Override
    public boolean isSorted() {
        return (Boolean) null ;
    }

    @Override
    public void sortedInsert(SNode node) {
    }

    @Override
    public SNode search(SNode node) {
        return null;
    }

    @Override
    public void delete(SNode node) {
    }

    @Override
    public void deleteTail() {
    }


    @Override
    public void clear(){
    }

    @Override
    public void print(){
    }



 
    



}