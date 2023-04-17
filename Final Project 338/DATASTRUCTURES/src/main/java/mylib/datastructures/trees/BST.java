package mylib.datastructures.trees;



import java.util.LinkedList;
import java.util.Queue;

public class BST {
// Inner class for tree node
class TNode {
    int data;
    TNode left;
    TNode right;

    public TNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

private TNode root;

public BST() {
    this.root = null;
}

public BST(int val) {
    this.root = new TNode(val);
}

public BST(TNode node) {
    this.root = node;
}

public TNode getRoot() {
    return this.root;
}

public void setRoot(TNode root) {
    this.root = root;
}

public void insert(int val) {
    TNode newNode = new TNode(val);
    if (this.root == null) {
        this.root = newNode;
        return;
    }

    TNode curr = this.root;
    while (true) {
        if (val < curr.data) {
            if (curr.left == null) {
                curr.left = newNode;
                return;
            }
            curr = curr.left;
        } else {
            if (curr.right == null) {
                curr.right = newNode;
                return;
            }
            curr = curr.right;
        }
    }
}

public void delete(int val) {
    TNode parent = null;
    TNode curr = this.root;
    boolean isLeftChild = false;

    while (curr != null && curr.data != val) {
        parent = curr;
        if (val < curr.data) {
            curr = curr.left;
            isLeftChild = true;
        } else {
            curr = curr.right;
            isLeftChild = false;
        }
    }

    if (curr == null) {
        System.out.println("Value " + val + " is not in the tree");
        return;
    }

    // Case 1: Node to be deleted has no children
    if (curr.left == null && curr.right == null) {
        if (curr == this.root) {
            this.root = null;
        } else {
            if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
    }

    // Case 2: Node to be deleted has one child
    else if (curr.right == null) {
        if (curr == this.root) {
            this.root = curr.left;
        } else if (isLeftChild) {
            parent.left = curr.left;
        } else {
            parent.right = curr.left;
        }
    } else if (curr.left == null) {
        if (curr == this.root) {
            this.root = curr.right;
        } else if (isLeftChild) {
            parent.left = curr.right;
        } else {
            parent.right = curr.right;
        }
    }

       // Case 3: Node to be deleted has two children
    else {
        TNode successor = getSuccessor(curr);
        if (curr == this.root) {
            this.root = successor;
        } else if (isLeftChild) {
            parent.left = successor;
        } else {
            parent.right = successor;
        }

        successor.left = curr.left;
    }
}

private TNode getSuccessor(TNode node) {
    TNode parent = node;
    TNode successor = node;
    TNode curr = node.right;

    while (curr != null) {
        parent = successor;
        successor = curr;
        curr = curr.left;
    }

    if (successor !=node.right) {
        parent.left = successor.right;
        successor.right = node.right;
        }
        return successor;
    }

    public TNode search(int val) {
    TNode curr = this.root;
    while (curr != null && curr.data != val) {
    if (val < curr.data) {
    curr = curr.left;
    } else {
    curr = curr.right;
    }
    }
    return curr;
}

public void printInOrder() {
inOrderTraversal(this.root);
System.out.println();
}

private void inOrderTraversal(TNode node) {
if (node == null) {
return;
}
inOrderTraversal(node.left);
System.out.print(node.data + " ");
inOrderTraversal(node.right);
}

public void printBF() {
if (this.root == null) {
return;
}
Queue<TNode> queue = new LinkedList<>();
queue.add(this.root);

while (!queue.isEmpty()) {
    int levelSize = queue.size();
    for (int i = 0; i < levelSize; i++) {
        TNode curr = queue.remove();
        System.out.print(curr.data + " ");
        if (curr.left != null) {
            queue.add(curr.left);
        }
        if (curr.right != null) {
            queue.add(curr.right);
        }
    }
    System.out.println();
}
}

public String inOrderTraversalString() {
    StringBuilder result = new StringBuilder();
    inOrderTraversalString(this.root, result);
    return result.toString();
}

private void inOrderTraversalString(TNode node, StringBuilder result) {
    if (node == null) {
        return;
    }
    inOrderTraversalString(node.left, result);
    result.append(node.data).append(" ");
    inOrderTraversalString(node.right, result);
}

}


