import java.util.Stack;

public class A1_112103078_q4_Stack {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to find the merging point of two linked lists using stacks
    private static ListNode findMergingPoint(ListNode head1, ListNode head2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        // Push nodes of the first list onto stack1
        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }

        // Push nodes of the second list onto stack2
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }

        ListNode mergingPoint = null;

        // Pop nodes from both stacks until they differ
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            mergingPoint = stack1.pop();
            stack2.pop();
        }

        return mergingPoint;
    }

    public static void main(String[] args) {
        // Create intersecting linked lists
        ListNode commonNode = new ListNode(8);
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(9);
        head1.next.next.next = commonNode;
        head1.next.next.next.next = new ListNode(15);
        head1.next.next.next.next.next = new ListNode(30);

        ListNode head2 = new ListNode(10);
        head2.next = commonNode;

        // Find the merging point using stacks
        ListNode mergingPoint = findMergingPoint(head1, head2);

        // Display the merging point value
        if (mergingPoint != null) {
            System.out.println("Merging Point Value: " + mergingPoint.val);
        } else {
            System.out.println("No merging point found");
        }
    }
}
