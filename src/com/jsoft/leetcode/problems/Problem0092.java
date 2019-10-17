package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.ListNode;
import com.jsoft.leetcode.helper.ListNodeHelper;

import java.util.List;

/**
 * Linked list
 * Reverse
 */
public class Problem0092 extends BaseProblem {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        //Create a dummy node
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // dummyHead(0) -> 1 -> 2 -> 3 -> 4 -> 5 -> 6

        ListNode prev = dummyHead;
        for(int i=0; i<m-1; i++) {
            prev = prev.next;
        }
        // prev = 1

        ListNode curr = prev.next;
        // curr = 2
        ListNode next = curr.next;
        // next = 3

        for(int i=m; i<n; i++) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
        // dummyHead(0) -> 1 -> 3 -> 2 -> 4 -> 5 -> 6
        // dummyHead(0) -> 1 -> 4 -> 3 -> 2 -> 5 -> 6
        // dummyHead(0) -> 1 -> 5 -> 4 -> 3 -> 2 -> 6

        return dummyHead.next;

    }

    @Override
    public void solve() {
        ListNode root = ListNodeHelper.createListNode(1,2,3,4,5,6,7);
        System.out.println(ListNodeHelper.toString(reverseBetween(root, 2,5)));

    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/reverse-linked-list/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0092());
    }
}
