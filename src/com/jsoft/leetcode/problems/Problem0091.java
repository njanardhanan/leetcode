package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;
import com.jsoft.leetcode.helper.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem0091 extends BaseProblem {

    public int numDecodings(String s) {
        return helper(s, new HashMap<>());
    }

    private int helper(String s, Map<String, Integer> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        if(s.equals("")){
            return 1;
        }
        if(s.charAt(0) == '0') {
            return 0;
        }
        int len = s.length();
        if(len == 1) {
            return 1;
        }
        int noOfWays = helper(s.substring(1), memo);
        if(len>=2) {
            String newString = s.substring(0, 2);
            if(Integer.parseInt(newString) <=26) {
                noOfWays += helper(s.substring(2), memo);
            }
        }
        memo.put(s, noOfWays);
        return noOfWays;
    }

    @Override
    public void solve() {
        TestHelper.test(numDecodings("226"), 3);
        TestHelper.test(numDecodings("12"), 2);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/decode-ways/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0091());
    }
}
