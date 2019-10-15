package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

public class Problem0009 extends BaseProblem {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        return (x == reverse(x));
    }

    public int reverse(int x) {
        int ans = 0;
        int sign = (x < 0) ? -1 : 1;
        x = x * sign;
        while(x > 0) {
            int t = x % 10;
            int newResult = ans * 10 + t;
            //Do reverse and check for correctness
            if ((newResult - t) / 10 != ans) {
                return 0;
            }
            x = x/10;
            ans = newResult;
        }

        return ans * sign;
    }

    @Override
    public void solve() {
        TestHelper.test(isPalindrome(121), true);
        TestHelper.test(isPalindrome(123), false);
        TestHelper.test(isPalindrome(-123), false);
        TestHelper.test(isPalindrome(120), false);
        TestHelper.test(isPalindrome(10), false);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/palindrome-number/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0009());
    }
}
