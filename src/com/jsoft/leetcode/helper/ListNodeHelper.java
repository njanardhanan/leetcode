package com.jsoft.leetcode.helper;

public class ListNodeHelper {
    public static ListNode createListNode(int... nums) {
        ListNode head = new ListNode(0);
        ListNode tmpHead = head;
        for (int n : nums) {
            tmpHead.next = new ListNode(n);
            tmpHead = tmpHead.next;
        }
        return head.next;
    }

    public static String toString(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }
}
