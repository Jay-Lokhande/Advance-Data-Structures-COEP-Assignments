import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class A2_BinomialHeapNode {
    int key, degree;
    A2_BinomialHeapNode parent, child, sibling;

    public A2_BinomialHeapNode(int key) {
        this.key = key;
        this.degree = 0;
        this.parent = null;
        this.child = null;
        this.sibling = null;
    }
}

class A2_BinomialHeap {
    A2_BinomialHeapNode head;

    public A2_BinomialHeap() {
        this.head = null;
    }

    public void merge(A2_BinomialHeapNode heap) {
        mergeTrees(heap);
        mergeHeaps();
    }

    private void mergeTrees(A2_BinomialHeapNode heap) {
        if (heap == null) return;

        if (head == null) {
            head = heap;
        } else {
            A2_BinomialHeapNode current = head;
            A2_BinomialHeapNode prev = null;
            A2_BinomialHeapNode next = head.sibling;

            while (next != null && heap.degree > current.degree) {
                prev = current;
                current = next;
                next = next.sibling;
            }

            if (prev == null) {
                heap.sibling = head;
                head = heap;
            } else {
                prev.sibling = heap;
                heap.sibling = current;
            }
        }
    }

    private void mergeHeaps() {
        if (head == null) return;

        A2_BinomialHeapNode prev = null;
        A2_BinomialHeapNode x = head;
        A2_BinomialHeapNode next = head.sibling;

        while (next != null) {
            if (x.degree != next.degree || (next.sibling != null && next.sibling.degree == x.degree)) {
                prev = x;
                x = next;
            } else {
                if (x.key <= next.key) {
                    x.sibling = next.sibling;
                    link(next, x);
                } else {
                    if (prev == null) {
                        head = next;
                    } else {
                        prev.sibling = next;
                    }
                    link(x, next);
                    x = next;
                }
            }
            next = x.sibling;
        }
    }

    private void link(A2_BinomialHeapNode smaller, A2_BinomialHeapNode larger) {
        smaller.parent = larger;
        smaller.sibling = larger.child;
        larger.child = smaller;
        larger.degree++;
    }

    public A2_BinomialHeapNode extractMin() {
        if (head == null) return null;

        A2_BinomialHeapNode minNode = findMin();
        A2_BinomialHeapNode prev = null;
        A2_BinomialHeapNode current = head;

        while (current != minNode) {
            prev = current;
            current = current.sibling;
        }

        if (prev == null) {
            head = current.sibling;
        } else {
            prev.sibling = current.sibling;
        }

        A2_BinomialHeap childHeap = new A2_BinomialHeap();
        A2_BinomialHeapNode child = minNode.child;
        while (child != null) {
            A2_BinomialHeapNode next = child.sibling;
            child.sibling = childHeap.head;
            childHeap.head = child;
            child = next;
        }

        merge(childHeap.head);

        return minNode;
    }

    public A2_BinomialHeapNode findMin() {
        if (head == null) return null;

        A2_BinomialHeapNode minNode = head;
        A2_BinomialHeapNode current = head.sibling;

        while (current != null) {
            if (current.key < minNode.key) {
                minNode = current;
            }
            current = current.sibling;
        }

        return minNode;
    }

    public void decreaseKey(A2_BinomialHeapNode node, int newKey) {
        if (node == null || newKey >= node.key) return;

        node.key = newKey;

        A2_BinomialHeapNode parent = node.parent;

        while (parent != null && node.key < parent.key) {
            int temp = node.key;
            node.key = parent.key;
            parent.key = temp;

            node = parent;
            parent = parent.parent;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}

class A2_Graph {
    int V;
    List<List<Node>> adjList;

    public A2_Graph(int V) {
        this.V = V;
        this.adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
        adjList.get(v).add(new Node(u, weight));
    }

    public List<Integer> dijkstra(int source) {
        List<Integer> dist = new ArrayList<>(Collections.nCopies(V, Integer.MAX_VALUE));
        dist.set(source, 0);

        A2_BinomialHeap heap = new A2_BinomialHeap();
        List<A2_BinomialHeapNode> nodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            A2_BinomialHeapNode node = new A2_BinomialHeapNode(i);
            nodes.add(node);
            heap.merge(node);
        }

        while (!heap.isEmpty()) {
            A2_BinomialHeapNode minNode = heap.extractMin();
            int u = minNode.key;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist.get(u) != Integer.MAX_VALUE && dist.get(u) + weight < dist.get(v)) {
                    dist.set(v, dist.get(u) + weight);
                    heap.decreaseKey(nodes.get(v), dist.get(v));
                }
            }
        }

        return dist;
    }

    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

public class A2_112103078_q4_DijkstraBinomialHeap {
    public static void main(String[] args) {
        int V = 5;
        A2_Graph a2Graph = new A2_Graph(V);

        // Adding edges to the graph
        a2Graph.addEdge(0, 1, 2);
        a2Graph.addEdge(0, 3, 1);
        a2Graph.addEdge(1, 2, 3);
        a2Graph.addEdge(1, 4, 5);
        a2Graph.addEdge(2, 4, 1);
        a2Graph.addEdge(3, 2, 4);

        int source = 0;
        List<Integer> distances = a2Graph.dijkstra(source);

        System.out.println("Shortest distances from vertex " + source + ": " + distances);
    }
}
