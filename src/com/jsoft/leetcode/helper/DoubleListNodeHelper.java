package com.jsoft.leetcode.helper;

public class DoubleListNodeHelper {
    public static DoubleListNode createListNode(int... nums) {
        DoubleListNode head = new DoubleListNode(0);
        DoubleListNode tmpHead = head;
        for (int n : nums) {
            tmpHead.next = new DoubleListNode(n);
            tmpHead.next.prev = tmpHead;
            tmpHead = tmpHead.next;
        }
        head.next.prev = null;
        return head.next;
    }

    public static String toString(DoubleListNode node) {
        StringBuilder sb = new StringBuilder();
        while(node != null) {
            sb.append(node.val);
            node = node.next;
        }
        return sb.toString();
    }
}
