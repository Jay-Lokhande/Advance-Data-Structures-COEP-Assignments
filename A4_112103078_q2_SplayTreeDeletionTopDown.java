
public class A4_112103078_q2_SplayTreeDeletionTopDown {
    private Node root;

    private Node splay(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key) {
            if (root.left == null)
                return root;
            if (key < root.left.key) {
                root.left.left = splay(root.left.left, key);
                root = rotateRight(root);
            } else if (key > root.left.key) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = rotateLeft(root.left);
            }
            return (root.left == null) ? root : rotateRight(root);
        } else {
            if (root.right == null)
                return root;
            if (key < root.right.key) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rotateRight(root.right);
            } else if (key > root.right.key) {
                root.right.right = splay(root.right.right, key);
                root = rotateLeft(root);
            }
            return (root.right == null) ? root : rotateLeft(root);
        }
    }

    private Node delete(Node root, int key) {
        if (root == null)
            return root;

        root = splay(root, key);

        if (root.key != key)
            return root;

        if (root.left == null)
            return root.right;
        else {
            Node temp = root;
            root = splay(root.left, key);
            root.right = temp.right;
        }

        return root;
    }

    public void delete(int key) {
        root = delete(root, key);
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
        A4_112103078_q2_SplayTreeDeletionTopDown splayTree = new A4_112103078_q2_SplayTreeDeletionTopDown();
        int[] insertValues = {20, 10, 30, 40, 45, 56, 70};
        System.out.println("Inserting values:");
        for (int value : insertValues) {
            splayTree.insert(value);
            System.out.print("After inserting " + value + ": ");
            splayTree.inorderTraversal(splayTree.root);
            System.out.println();
        }

        int deleteValue = 45;
        System.out.println("\nDeleting value " + deleteValue + ":");
        splayTree.delete(deleteValue);
        splayTree.inorderTraversal(splayTree.root);
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
}
