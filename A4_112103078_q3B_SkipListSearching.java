//class SkipListNode {
//    int value;
//    SkipListNode next;
//    SkipListNode down;
//
//    SkipListNode(int value) {
//        this.value = value;
//        this.next = null;
//        this.down = null;
//    }
//}

public class A4_112103078_q3B_SkipListSearching {
    private SkipListNode head;

    public A4_112103078_q3B_SkipListSearching() {
        this.head = new SkipListNode(Integer.MIN_VALUE);
    }

    public boolean search(int target) {
        SkipListNode current = head;
        while (current != null) {
            while (current.next != null && current.next.value < target) {
                current = current.next;
            }
            if (current.next != null && current.next.value == target) {
                return true;
            }
            current = current.below;
        }
        return false;
    }

    public static void main(String[] args) {
        A4_112103078_q3B_SkipListSearching skipList = new A4_112103078_q3B_SkipListSearching();
        // Build the skip list
        skipList.head.below = new SkipListNode(2);
        skipList.head.below.next = new SkipListNode(5);
        skipList.head.below.next.next = new SkipListNode(8);
        skipList.head.below.next.next.next = new SkipListNode(12);
        skipList.head.below.next.next.next.next = new SkipListNode(15);

        int value1 = 14;
        int value2 = 12;

        System.out.println("Searching for " + value1 + ": " + skipList.search(value1));
        System.out.println("Searching for " + value2 + ": " + skipList.search(value2));
    }
}
