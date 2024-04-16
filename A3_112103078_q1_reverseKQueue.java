import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A3_112103078_q1_reverseKQueue {
    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size())
            return;

        Stack<Integer> stack = new Stack<>();

        // Push the first k elements into the stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Pop elements from the stack and enqueue them back to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Move the remaining elements after the first k elements to the end of the queue
        for (int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int k = 3; // Number of elements to reverse

        // Adding elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Original Queue: " + queue);

        reverseFirstKElements(queue, k);

        System.out.println("Queue after reversing first " + k + " elements: " + queue);
    }
}
