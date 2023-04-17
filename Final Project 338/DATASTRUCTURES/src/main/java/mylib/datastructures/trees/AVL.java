package mylib.datastructures.trees;
public class AVL extends BST {
    // Inner class for AVL node
    class AVLNode extends TNode {
        int height;

        public AVLNode(int data) {
            super(data);
            this.height = 1;
        }
    }

    public AVL() {
        super();
    }

    public AVL(int val) {
        super(val);
        this.setRoot(new AVLNode(val));
    }

    public AVL(TNode node) {
        super(node);
    }

    @Override
    public void insert(int val) {
        this.setRoot(insertRecursively((AVLNode) this.getRoot(), val));
    }

    private AVLNode insertRecursively(AVLNode node, int val) {
        if (node == null) {
            return new AVLNode(val);
        }

        if (val < node.data) {
            node.left = insertRecursively((AVLNode) node.left, val);
        } else {
            node.right = insertRecursively((AVLNode) node.right, val);
        }

        node.height = 1 + Math.max(getHeight((AVLNode) node.left), getHeight((AVLNode) node.right));

        int balance = getBalance(node);

        if (balance > 1) {
            if (val < node.left.data) {
                return rightRotate(node);
            } else {
                node.left = leftRotate((AVLNode) node.left);
                return rightRotate(node);
            }
        }

        if (balance < -1) {
            if (val > node.right.data) {
                return leftRotate(node);
            } else {
                node.right = rightRotate((AVLNode) node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private int getHeight(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalance(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight((AVLNode) node.left) - getHeight((AVLNode) node.right);
    }

    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = (AVLNode) y.left;
        TNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(getHeight((AVLNode) y.left), getHeight((AVLNode) y.right)) + 1;
        x.height = Math.max(getHeight((AVLNode) x.left), getHeight((AVLNode) x.right)) + 1;

        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = (AVLNode) x.right;
        TNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(getHeight((AVLNode) x.left), getHeight((AVLNode) x.right)) + 1;
        y.height = Math.max(getHeight((AVLNode) y.left), getHeight((AVLNode) y.right)) + 1;

        return y;
    }

    // Override delete method for AVL trees
    @Override
    public void delete(int val) {
        this.setRoot(deleteRecursively((AVLNode) this.getRoot(), val));
    }

    private AVLNode deleteRecursively(AVLNode node, int val) {
        if (node == null) {
            return node;
        }
    
        if (val < node.data) {
            node.left = deleteRecursively((AVLNode) node.left, val);
        } else if (val > node.data) {
            node.right = deleteRecursively((AVLNode) node.right, val);
        } else {
            if ((node.left == null) || (node.right == null)) {
                AVLNode temp = null;
                if (temp == node.left) {
                    temp = (AVLNode) node.right;
                } else {
                    temp = (AVLNode) node.left;
                }
    
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                node.data = minValue((AVLNode) node.right);
                node.right = deleteRecursively((AVLNode) node.right, node.data);
            }
        }
    
        if (node == null) {
            return node;
        }
    
        node.height = Math.max(getHeight((AVLNode) node.left), getHeight((AVLNode) node.right)) + 1;
        int balance = getBalance(node);
    
        if (balance > 1) {
            if (getBalance((AVLNode) node.left) < 0) {
                node.left = leftRotate((AVLNode) node.left);
            }
            return rightRotate(node);
        }
    
        if (balance < -1) {
            if (getBalance((AVLNode) node.right) > 0) {
                node.right = rightRotate((AVLNode) node.right);
            }
            return leftRotate(node);
        }
    
        return node;
    }
    
    private int minValue(AVLNode node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = (AVLNode) node.left;
        }
        return minValue;
    }
    public String inOrderTraversalString() {
        StringBuilder result = new StringBuilder();
        inOrderTraversalString(this.getRoot(), result);
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
