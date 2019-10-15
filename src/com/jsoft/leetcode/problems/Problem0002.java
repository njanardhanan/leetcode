package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.ListNode;
import com.jsoft.leetcode.helper.ListNodeHelper;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.HashMap;

public class Problem0002 extends BaseProblem {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmpHead = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            val += carry;
            tmpHead.next = new ListNode(val%10);
            tmpHead = tmpHead.next;
            carry = val/10;
        }
        return head.next;
    }

    @Override
    public void solve() {
        String actual = ListNodeHelper.toString(addTwoNumbers(ListNodeHelper.createListNode(2,4,3),
                ListNodeHelper.createListNode(5,6,4)));
        String expected = ListNodeHelper.toString(ListNodeHelper.createListNode(7,0,8));
        TestHelper.test(actual, expected);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/add-two-numbers/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0002());
    }
}
