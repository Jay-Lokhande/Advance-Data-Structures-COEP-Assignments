import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class A3_112103078_q4_IncresingOrderQueue {

    public static boolean canArrangeInIncreasingOrder(Queue<Integer> queue) {
        int expectedNumber = 1;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> resultQueue = new LinkedList<>();

        while (!queue.isEmpty() || !stack.isEmpty()) {
            if (!queue.isEmpty() && queue.peek() == expectedNumber) {
                resultQueue.offer(queue.poll());
                expectedNumber++;
            } else if (!stack.isEmpty() && stack.peek() == expectedNumber) {
                resultQueue.offer(stack.pop());
                expectedNumber++;
            } else if (!queue.isEmpty()) {
                stack.push(queue.poll());
            } else {
                return false;
            }
        }

        // Print the arrangement in increasing order
        System.out.println("Arrangement in increasing order: " + resultQueue);

        return true;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        // Populate the queue with first n natural numbers in random order
        queue.add(2);
        queue.add(1);
        queue.add(4);
        queue.add(3);

        System.out.println("Original Queue: " + queue);

        // Check if the elements can be arranged in increasing order
        boolean result = canArrangeInIncreasingOrder(queue);
        if (result) {
            System.out.println("The elements can be arranged in increasing order.");
        } else {
            System.out.println("The elements cannot be arranged in increasing order.");
        }
    }
}
