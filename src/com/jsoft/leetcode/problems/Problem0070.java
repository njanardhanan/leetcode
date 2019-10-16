package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

import java.util.HashMap;
import java.util.Map;

public class Problem0070 extends BaseProblem {

    Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        if(memo.containsKey(n)) return memo.get(n);
        int ans = climbStairs(n-1)+climbStairs(n-2);
        memo.put(n, ans);
        return ans;
    }

    @Override
    public void solve() {
        TestHelper.test(climbStairs(2), 2);
        TestHelper.test(climbStairs(3), 3);
        TestHelper.test(climbStairs(5), 8);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/climbing-stairs/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0070());
    }
}
