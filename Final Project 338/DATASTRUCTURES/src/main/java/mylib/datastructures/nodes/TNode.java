package mylib.datastructures.nodes;
public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    private TNode parent;
    private int balance;

    // Default constructor
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    // Overload constructor
    public TNode(int data, int balance, TNode parent, TNode left, TNode right) {
        this.data = data;
        this.balance = balance;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    // Getters
    public int getData() {
        return this.data;
    }

    public TNode getLeft() {
        return this.left;
    }

    public TNode getRight() {
        return this.right;
    }

    public TNode getParent() {
        return this.parent;
    }

    public int getBalance() {
        return this.balance;
    }

    // Setters
    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(TNode left) {
        this.left = left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    public void setParent(TNode parent) {
        this.parent = parent;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // toString method
    public String toString() {
        return Integer.toString(this.data);
    }

    // print method
    public void print() {
        System.out.println("Data: " + this.data + ", Balance: " + this.balance);
    }
}
