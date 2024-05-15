package Medium;

import java.util.Stack;

public class RemoveNodesFromLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        ListNode newHead = removeNodes(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static ListNode removeNodes(ListNode head) {
        Stack<Integer> stk = new Stack<>();
        if (head == null) return null;
        while (head.next != null) {
            stk.push(head.val);
            head = head.next;
        }
        int pop = stk.pop();
        ListNode result = new ListNode(pop);
        ListNode newNode = new ListNode();
        while (!stk.isEmpty()) {
            if (stk.peek() > pop) {
                pop = stk.pop();
                newNode = new ListNode(pop);
                result.next = newNode;
            } else {
                stk.pop();
            }
        }
        return result;
    }
}
