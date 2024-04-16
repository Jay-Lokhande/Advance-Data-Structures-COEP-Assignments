import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A3_112103078_q2A_stackQueueRearrangeHalf {

    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            throw new IllegalArgumentException("Queue length must be even.");
        }

        int halfSize = queue.size() / 2;
        Stack<Integer> stack = new Stack<>();

        // Push the first half of the queue into the stack in reverse order
        for (int i = 0; i < halfSize; i++) {
            stack.push(queue.poll());
        }

        // Interleave elements from the stack and the remaining elements in the queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);

        System.out.println("Original queue: " + queue);
        interleaveQueue(queue);
        System.out.println("Interleaved queue: " + queue);
    }
}
