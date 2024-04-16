import java.util.*;

class SkipListNode {
    int value;
    SkipListNode next;
    SkipListNode below;

    public SkipListNode(int value) {
        this.value = value;
        this.next = null;
        this.below = null;
    }
}

class SkipList {
    SkipListNode head;
    Random random;

    public SkipList() {
        this.head = new SkipListNode(Integer.MIN_VALUE);
        this.random = new Random();
    }

    public void insert(int value) {
        SkipListNode cur = head;
        List<SkipListNode> toUpdate = new ArrayList<>();

        while (cur != null) {
            while (cur.next != null && cur.next.value < value) {
                cur = cur.next;
            }
            toUpdate.add(cur);
            cur = cur.below;
        }

        boolean insertAbove = true;
        SkipListNode belowNode = null;

        for (int i = toUpdate.size() - 1; i >= 0; i--) {
            cur = toUpdate.get(i);
            SkipListNode newNode = new SkipListNode(value);
            newNode.below = belowNode;

            if (insertAbove) {
                belowNode = newNode;
            }

            newNode.next = cur.next;
            cur.next = newNode;

            insertAbove = random.nextBoolean();

            if (insertAbove && i == 0) {
                SkipListNode newHead = new SkipListNode(Integer.MIN_VALUE);
                newHead.next = head;
                newHead.below = belowNode;
                head = newHead;
            }
        }
    }

    public void display() {
        SkipListNode cur = head;

        while (cur != null) {
            SkipListNode temp = cur;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
            cur = cur.below;
        }
    }
}

public class A4_112103078_q3A_SkipListInsertion {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 15};
        SkipList skipList = new SkipList();
        for (int num : arr) {
            skipList.insert(num);
        }
        skipList.display();
    }
}
