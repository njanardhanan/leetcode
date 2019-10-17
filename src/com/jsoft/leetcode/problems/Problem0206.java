package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.ListNode;
import com.jsoft.leetcode.helper.ListNodeHelper;

/**
 * Linked list
 * Reverse
 */
public class Problem0206 extends BaseProblem {

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    @Override
    public void solve() {
        ListNode root = ListNodeHelper.createListNode(1,2,3,4,5);
        System.out.println(ListNodeHelper.toString(reverseList(root)));

    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/reverse-linked-list/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0206());
    }
}
