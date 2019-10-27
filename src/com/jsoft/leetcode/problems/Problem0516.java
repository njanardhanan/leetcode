package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

/**
 * String
 * SubSequence
 * Longest Palindrome
 */
public class Problem0516 extends BaseProblem {

    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 1;
        return longestPalindromeSubseq(s.toCharArray(), 0, s.length()-1, new int[s.length()][s.length()]);
    }

    private int longestPalindromeSubseq(char[] s, int l, int r, int[][] memo) {

        if(l>r) return 0;
        if(l == r) return 1;

        if (memo[l][r] != 0) {
            return memo[l][r];
        }

        if (s[l] == s[r]) {
            memo[l][r] = 2 + longestPalindromeSubseq(s, l+1, r-1, memo);
        } else {
            memo[l][r] = Math.max(longestPalindromeSubseq(s, l, r-1, memo), longestPalindromeSubseq(s, l+1, r, memo));
        }

        return memo[l][r];

    }

    @Override
    public void solve() {
        TestHelper.test(longestPalindromeSubseq("bbbab"),4);
        TestHelper.test(longestPalindromeSubseq("cbbd"),2);
        TestHelper.test(longestPalindromeSubseq("aaa"),3);
    }

    @Override
    public String getProblemURL() {
        return "https://leetcode.com/problems/longest-palindromic-subsequence/";
    }

    public static void main(String[] args) {
        baseMain(new Problem0516());
    }
}
