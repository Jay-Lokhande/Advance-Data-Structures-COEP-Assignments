import java.util.LinkedList;
import java.util.Queue;

public class A3_112103078_q2B_queueQueueRearrange {

    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            throw new IllegalArgumentException("Queue length must be even.");
        }

        int halfSize = queue.size() / 2;
        Queue<Integer> firstHalf = new LinkedList<>();
        Queue<Integer> secondHalf = new LinkedList<>();

        // Split the original queue into two halves
        for (int i = 0; i < halfSize; i++) {
            firstHalf.offer(queue.poll());
        }
        while (!queue.isEmpty()) {
            secondHalf.offer(queue.poll());
        }

        // Interleave elements from the first and second halves
        while (!firstHalf.isEmpty()) {
            queue.offer(firstHalf.poll());
            queue.offer(secondHalf.poll());
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
