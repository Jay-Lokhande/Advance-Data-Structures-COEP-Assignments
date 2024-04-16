class SkewHeapNodes {
    int key;
    SkewHeapNodes left;
    SkewHeapNodes right;

    public SkewHeapNodes(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class A2_112103078_q3_SkewHeap {
    private SkewHeapNodes root;

    public A2_112103078_q3_SkewHeap() {
        this.root = null;
    }

    public A2_112103078_q3_SkewHeap(SkewHeapNodes root) {
        this.root = root;
    }

    public void merge(A2_112103078_q3_SkewHeap otherHeap) {
        this.root = merge(this.root, otherHeap.root);
    }

    private SkewHeapNodes merge(SkewHeapNodes h1, SkewHeapNodes h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }

        // Swap children to maintain skew property
        SkewHeapNodes temp = h1.left;
        h1.left = h1.right;
        h1.right = temp;

        h1.left = merge(h1.left, h2);
        return h1;
    }

    public void display() {
        display(root);
        System.out.println();
    }

    private void display(SkewHeapNodes node) {
        if (node != null) {
            display(node.left);
            System.out.print(node.key + " ");
            display(node.right);
        }
    }

    public static void main(String[] args) {
        A2_112103078_q3_SkewHeap skewHeap1 = new A2_112103078_q3_SkewHeap();
        A2_112103078_q3_SkewHeap skewHeap2 = new A2_112103078_q3_SkewHeap();

//        int[] values1 = { 5, 12, 8, 3, 20 };
        int[] values1 = { 2, 4, 22 };
//        int[] values2 = { 7, 15, 10, 6, 18 };
        int[] values2 = { 12, 18, 90 };

        System.out.println("Inserting values into Skew Heap 1:");
        for (int value : values1) {
            skewHeap1.merge(new A2_112103078_q3_SkewHeap(new SkewHeapNodes(value)));
            skewHeap1.display();
        }

        System.out.println("\nInserting values into Skew Heap 2:");
        for (int value : values2) {
            skewHeap2.merge(new A2_112103078_q3_SkewHeap(new SkewHeapNodes(value)));
            skewHeap2.display();
        }

        System.out.println("\nMerging Skew Heap 1 and Skew Heap 2:");
        skewHeap1.merge(skewHeap2);
        skewHeap1.display();
    }
}
