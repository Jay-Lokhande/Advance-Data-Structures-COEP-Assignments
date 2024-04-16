class LeftistHeapNodes {
    int key;
    int nullPathLength;
    LeftistHeapNodes left;
    LeftistHeapNodes right;

    public LeftistHeapNodes(int key) {
        this.key = key;
        this.nullPathLength = 0;
        this.left = null;
        this.right = null;
    }
}

public class A2_112103078_q1_q2_LeftistHeap {
    private LeftistHeapNodes root;

    public A2_112103078_q1_q2_LeftistHeap() {
        this.root = null;
    }

    public void insert(int key) {
        this.root = merge(this.root, new LeftistHeapNodes(key));
    }

    private LeftistHeapNodes merge(LeftistHeapNodes h1, LeftistHeapNodes h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }

        if (h1.key > h2.key) {
            LeftistHeapNodes temp = h1;
            h1 = h2;
            h2 = temp;
        }

        h1.right = merge(h1.right, h2);

        if (h1.left == null || h1.left.nullPathLength < h1.right.nullPathLength) {
            LeftistHeapNodes temp = h1.left;
            h1.left = h1.right;
            h1.right = temp;
        }

        if (h1.right == null) {
            h1.nullPathLength = 0;
        } else {
            h1.nullPathLength = h1.right.nullPathLength + 1;
        }

        return h1;
    }

    public void display() {
        display(root);
        System.out.println();
    }

    private void display(LeftistHeapNodes node) {
        if (node != null) {
            display(node.left);
            System.out.print(node.key + " ");
            display(node.right);
        }
    }

    public int deleteMin() {
        if (root == null) {
            System.out.println("Heap is empty. Cannot delete minimum element.");
            return -1; // Assuming -1 represents an invalid value in this context
        }

        int minValue = root.key;
        root = merge(root.left, root.right);

        return minValue;
    }

    public static void main(String[] args) {
        A2_112103078_q1_q2_LeftistHeap leftistHeap = new A2_112103078_q1_q2_LeftistHeap();
        int[] values = { 77, 22, 9, 68, 16, 34, 13, 8 };

        System.out.println("Inserting values into Leftist Heap:");
        for (int value : values) {
            leftistHeap.insert(value);
            leftistHeap.display();
        }

        System.out.println("\nDeleting minimum elements from Leftist Heap:");
        while (leftistHeap.root != null) {
            int deletedValue = leftistHeap.deleteMin();
            System.out.println("Deleted min: " + deletedValue);
            leftistHeap.display();
        }
    }
}
