package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.HashMap;
import java.util.Map;

public class Problem0007 extends BaseProblem {

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
        TestHelper.test(reverse(123), 321);
        TestHelper.test(reverse(-123), -321);
        TestHelper.test(reverse(120), 21);
        TestHelper.test(reverse(1534236469), 0);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/reverse-integer/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0007());
    }
}
