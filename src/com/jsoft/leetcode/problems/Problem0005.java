package com.jsoft.leetcode.problems;

import com.jsoft.leetcode.base.BaseProblem;
import com.jsoft.leetcode.helper.TestHelper;

/**
 * Longest palindrome substring
 */
public class Problem0005 extends BaseProblem {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int n = s.length();
        char[] chars = s.toCharArray();
        int maxPalindromeLen = 0;
        int palindromeStartIndex = 0;

        boolean[][] T = new boolean[n][n];

        for(int i=0; i<n; i++) {
            T[i][i] = true;
        }

        //Update palindrome for length 2
        for(int i=0; i<n-1; i++) {
            if(chars[i] == chars[i+1]) {
                T[i][i+1] = true;
                maxPalindromeLen = 2;
                palindromeStartIndex = i;
            }
        }

        //Update for other len (>2)
        for(int currLen=3; currLen<=n; currLen++) {
            for(int i=0; i<n-currLen+1; i++) {
                int j = i + currLen - 1;
                if(chars[i] == chars[j] && T[i+1][j-1] ) {
                    T[i][j] = true;
                    maxPalindromeLen = currLen;
                    palindromeStartIndex = i;
                }
            }
        }

        return s.substring(palindromeStartIndex, palindromeStartIndex + maxPalindromeLen);

    }

    private void displayT(boolean[][] T) {
        for(boolean[] b : T) {
            for(boolean x : b) {
                if(x) {
                    System.out.printf("T ");
                } else {
                    System.out.printf("F ");
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    @Override
    public void solve() {
        TestHelper.test(longestPalindrome("babad"), "aba");
        TestHelper.test(longestPalindrome("cbbd"), "bb");
        TestHelper.test(longestPalindrome("banana"), "anana");
        TestHelper.test(longestPalindrome("abaxabaxabybaxabyb"), "baxabybaxab");
    }

    @Override
    public String getProblemURL() {
        return "";
    }

    public static void main(String[] args) {
        baseMain(new Problem0005());
    }
}
