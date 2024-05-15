package Medium;

// Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNodeInLinkedList {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);

        deleteNode(node.next);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void deleteNode(ListNode node) {
        // Copy the value of the next node to the current node
        // 4 -> 5 -> 1 -> 9 -> null [node = 5] [before]
        node.val = node.next.val;
        // 4 -> 1 -> 1 -> 9 -> null [node = 5] [after]

        // Skip the next node
        node.next = node.next.next;
        // 4 -> 1 -> 9 -> null [node = 5] [after]
    }
}
