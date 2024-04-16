import java.util.Arrays;

public class A1_112103078_q4_SortingTechnique {


        public static class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
                this.next = null;
            }
        }

        // Merge two linked lists into a single linked list
        private static ListNode mergeLists(ListNode head1, ListNode head2) {
            ListNode mergedHead = new ListNode(-1);
            ListNode current = mergedHead;

            while (head1 != null) {
                current.next = new ListNode(head1.val);
                current = current.next;
                head1 = head1.next;
            }

            while (head2 != null) {
                current.next = new ListNode(head2.val);
                current = current.next;
                head2 = head2.next;
            }

            return mergedHead.next;
        }

        // Sort the linked list using an array
        private static ListNode sortList(ListNode head) {
            ListNode current = head;
            int count = 0;

            // Count the number of nodes in the list
            while (current != null) {
                count++;
                current = current.next;
            }

            int[] arr = new int[count];
            current = head;

            // Copy values to an array
            for (int i = 0; i < count; i++) {
                arr[i] = current.val;
                current = current.next;
            }

            // Sort the array
            Arrays.sort(arr);

            // Copy values back to the linked list
            current = head;
            for (int i = 0; i < count; i++) {
                current.val = arr[i];
                current = current.next;
            }

            return head;
        }

        // Find the merging point of two linked lists
        private static ListNode findMergingPoint(ListNode head) {
            while (head != null && head.next != null) {
                if (head.val == head.next.val) {
                    return head;
                }
                head = head.next;
            }
            return null;
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

            // Merge and sort the linked lists

            ListNode mergedHead = mergeLists(head1, head2);
            ListNode sortedHead = sortList(mergedHead);

            // Find the merging point
            ListNode mergingPoint = findMergingPoint(sortedHead);

            // Display the merging point value
            if (mergingPoint != null) {
                System.out.println("Merging Point Value: " + mergingPoint.val);
            } else {
                System.out.println("No merging point found");
            }
        }

}
