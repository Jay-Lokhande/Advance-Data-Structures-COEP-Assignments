class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class A4_112103078_q1_SplayTreeInsertionBottomUp {
    private Node root;

    private Node splay(Node x, int key) {
        if (x == null || x.key == key)
            return x;

        if (key < x.key) {
            if (x.left == null)
                return x;

            if (key < x.left.key) {
                x.left.left = splay(x.left.left, key);
                x = rotateRight(x);
            } else if (key > x.left.key) {
                x.left.right = splay(x.left.right, key);
                if (x.left.right != null)
                    x.left = rotateLeft(x.left);
            }

            return (x.left == null) ? x : rotateRight(x);
        } else {
            if (x.right == null)
                return x;

            if (key < x.right.key) {
                x.right.left = splay(x.right.left, key);
                if (x.right.left != null)
                    x.right = rotateRight(x.right);
            } else if (key > x.right.key) {
                x.right.right = splay(x.right.right, key);
                x = rotateLeft(x);
            }

            return (x.right == null) ? x : rotateLeft(x);
        }
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        root = splay(root, key);
        if (key < root.key) {
            Node newNode = new Node(key);
            newNode.left = root.left;
            newNode.right = root;
            root.left = null;
            root = newNode;
        } else if (key > root.key) {
            Node newNode = new Node(key);
            newNode.right = root.right;
            newNode.left = root;
            root.right = null;
            root = newNode;
        }
    }

    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        A4_112103078_q1_SplayTreeInsertionBottomUp splayTree = new A4_112103078_q1_SplayTreeInsertionBottomUp();
        int[] insertValues = {20, 10, 30, 40, 45, 56, 70};
        System.out.println("Inserting values:");
        for (int value : insertValues) {
            splayTree.insert(value);
            System.out.print("After inserting " + value + ": ");
            splayTree.inorderTraversal(splayTree.root);
            System.out.println();
        }
    }
}
